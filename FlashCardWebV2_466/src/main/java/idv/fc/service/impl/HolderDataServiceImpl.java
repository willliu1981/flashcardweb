package idv.fc.service.impl;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.fc.dao.itf.HolderDataDao;
import idv.fc.dao.itf.StatusDao;
import idv.fc.model.HolderData;
import idv.fc.model.Status;
import idv.fc.model.dto.HolderDataDTO;
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
	private IStatusService statusService;

	@Autowired
	private QuizPlayStrategyContext<HolderDataDTO> playStrategyContext;

	@Override
	public List<HolderData> getAll() {
		return holderDataDao.selectAll();
	}

	@Override
	public HolderDataDTO getDTOById(String id) {
		return holderDataDao.selectByIdJoinFH(id);
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
	public List<HolderDataDTO> getAllJoinFHWithFilterAndMod(String filter,
			String mod, Integer num) {
		List<HolderDataDTO> all = this.holderDataDao.selectAllJoinFh();
		List<HolderDataDTO> allWithoutEmptyFlashcard = all.stream()
				.filter(x -> x.getFlashcardHolderDTO().getFlashcard() != null)
				.collect(Collectors.toList());

		playStrategyContext.setFilter(filter);
		playStrategyContext.setMod(mod);

		return playStrategyContext
				.executeStrategyForGetAll(allWithoutEmptyFlashcard, num);
	}

	@Override
	public void updateForQuizFinish(Integer[] datas, String filter) {

		List<Integer> list = Arrays.stream(datas).collect(Collectors.toList());

		List<HolderDataDTO> all = this.holderDataDao.selectAllJoinFh();

		List<HolderDataDTO> collect = all.stream()
				.filter(x -> list.contains(x.getId()))
				.collect(Collectors.toList());

		playStrategyContext.setFilter(filter);
		List<HolderDataDTO> findForUpdate = playStrategyContext
				.executeStrategyForUpdate(collect);
		//進行update
		findForUpdate.stream().forEach(x -> {
			this.flashcardService
					.edit(x.getFlashcardHolderDTO().getFlashcard());
			this.flashcardHolderService.edit(x.getFlashcardHolderDTO());
			this.statusService.edit(x.getStatus());
		});

	}

	@Override
	public HolderData getById(String id) {
		try {
			return this.holderDataDao.selectById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
