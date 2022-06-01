package idv.fc.quiz.playstrategy.filterimpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import idv.fc.model.Flashcard;
import idv.fc.model.Status;
import idv.fc.model.dto.FlashcardHolderDTO;
import idv.fc.model.dto.HolderDataDTO;
import idv.fc.quiz.phaseexception.QuizPhaseInvalidException;
import idv.fc.quiz.phasestrategy.QuizPhaseStrategyContext;
import idv.fc.quiz.playstrategy.QuizFilter;
import idv.fc.quiz.strategy.PhaseRuleExecutor;

@Repository("periodFilter")
public class PeriodFilter implements QuizFilter<HolderDataDTO> {
	@Autowired
	private PhaseRuleExecutor re;

	@Autowired
	private QuizPhaseStrategyContext phaseStrategyContext;

	@Override
	public List<HolderDataDTO> doOperation(List<HolderDataDTO> origDatas) {

		List<HolderDataDTO> filterTime = origDatas.stream().filter(x -> {

			if (!re.isValidPhase(x.getStatus().getPhase())) {
				return false;
			}

			//begin time or end time ==null, 代表該phase 尚未開始,即無初始紀錄
			if (x.getStatus().getEndTimeOfPhase() == null) {
				return true;
			}

			boolean before = x.getStatus().getEndTimeOfPhase()
					.before(new Date());

			return before;
		}).collect(Collectors.toList());

		return filterTime;
	}

	@Override
	public List<HolderDataDTO> doOperationForUpdate(
			List<HolderDataDTO> origDatas) {

		return origDatas.stream().map(x -> {
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

			HolderDataDTO newDTO = new HolderDataDTO();
			newDTO.setFlashcardHolderDTO(flashcardHolderDTO);
			newDTO.setStatus(status);

			return newDTO;
		}).collect(Collectors.toList());
	}

}
