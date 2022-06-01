package idv.fc.service.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.fc.dao.itf.HolderDataDao;
import idv.fc.dao.itf.StatusDao;
import idv.fc.model.Flashcard;
import idv.fc.model.HolderData;
import idv.fc.model.Status;
import idv.fc.model.dto.FlashcardHolderDTO;
import idv.fc.model.dto.HolderDataDTO;
import idv.fc.quiz.phaseexception.QuizPhaseInvalidException;
import idv.fc.quiz.phasestrategy.QuizPhaseStrategyContext;
import idv.fc.quiz.playstrategy.QuizPlayStrategyContext;
import idv.fc.service.abstraction.IFlashcardHolderService;
import idv.fc.service.abstraction.IFlashcardService;
import idv.fc.service.abstraction.IHolderDataService;
import idv.fc.service.abstraction.IStatusService;

@Service("holderDataService")
public class HolderDataServiceImpl implements IHolderDataService {

	@Autowired
	private HolderDataDao holderDataDao;

	@Autowired
	private StatusDao statusDao;

	@Autowired
	IFlashcardService flashcardService;

	@Autowired
	IFlashcardHolderService flashcardHolderService;

	@Autowired
	IHolderDataService holderDataService;

	@Autowired
	private IStatusService statusService;

	@Autowired
	private QuizPlayStrategyContext<HolderDataDTO> playStrategyContext;

	@Autowired
	private QuizPhaseStrategyContext phaseStrategyContext;

	@Override
	public List<HolderData> getAll() {
		return holderDataDao.selectAll();
	}

	@Override
	public HolderData getById(String id) {
		try {
			return holderDataDao.selectById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addNew(HolderData holderData) {
		try {
			Status status = new Status();
			statusService.addNew(status);

			holderData.setStatusId(status.getId());
			holderDataDao.create(holderData);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(HolderData holderData) {
		try {
			holderDataDao.update(holderData);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String id) {
		try {
			/*holderDataDao.delete(id);*/
			//藉由刪除status 由sql 自動(連瑣)刪除 holderData 
			Integer statusId = holderDataDao.selectById(id).getStatusId();
			statusService.remove(statusId.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<HolderDataDTO> getAllJoinFH() {
		return this.holderDataDao.selectAllJoinFh();
	}

	/**
	 * mod 來自quizmanagedPage.jsp 的radioMod 值
	 */
	@Override
	public List<HolderDataDTO> getAllJoinFH(String filter, String mod,
			Integer num) {
		List<HolderDataDTO> all = this.holderDataDao.selectAllJoinFh();

		playStrategyContext.setFilter(filter);
		playStrategyContext.setMod(mod);

		return playStrategyContext.executeStrategy(all, num);
	}

	@Override
	public void updateForQuizFinish(Integer[] datas) {

		List<Integer> list = Arrays.stream(datas).collect(Collectors.toList());

		List<HolderDataDTO> all = holderDataService.getAllJoinFH();

		Stream<HolderDataDTO> stream = all.stream()
				.filter(x -> x.getFlashcardHolderDTO().getFlashcard() != null
						&& list.contains(x.getFlashcardHolderDTO()
								.getFlashcard().getId()));

		stream.forEach(x -> {
			//---status 
			Status status = x.getStatus();
			status.setBeginTimeOfPhase(new Timestamp(new Date().getTime()));

			Integer phase = status.getPhase();
			Timestamp phaseResultTime = null;
			try {
				phaseResultTime = phaseStrategyContext.executeStrategy(
						new Timestamp(new Date().getTime()), phase);
				status.setEndTimeOfPhase(phaseResultTime);
				status.setPhase(status.getPhase() + 1);
			} catch (QuizPhaseInvalidException e) {
				status.setEndTimeOfPhase(null);
			}
			//---//status 

			FlashcardHolderDTO flashcardHolderDTO = x.getFlashcardHolderDTO();
			flashcardHolderDTO.setNumberOfQuizTimes(
					flashcardHolderDTO.getNumberOfQuizTimes() + 1);

			Flashcard flashcard = x.getFlashcardHolderDTO().getFlashcard();
			flashcard
					.setNumberOfQuizTimes(flashcard.getNumberOfQuizTimes() + 1);

			this.flashcardService.edit(flashcard);
			this.flashcardHolderService.edit(flashcardHolderDTO);
			this.statusService.edit(status);

		});

	}

}
