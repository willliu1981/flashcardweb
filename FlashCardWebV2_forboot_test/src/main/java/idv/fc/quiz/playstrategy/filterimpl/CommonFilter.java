package idv.fc.quiz.playstrategy.filterimpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import idv.debug.Debug;
import idv.fc.model.Flashcard;
import idv.fc.model.Status;
import idv.fc.model.dto.FlashcardHolderDTO;
import idv.fc.model.dto.HolderDataDTO;
import idv.fc.quiz.playstrategy.QuizFilter;
import idv.fc.quiz.playstrategy.QuizPlayStrategyContext;
import idv.fc.quiz.playstrategy.QuizPlayStrategyContextFactory;

@Repository("commonFilter")
public class CommonFilter implements QuizFilter<HolderDataDTO> {

	@Autowired
	@Lazy
	private QuizPlayStrategyContext<HolderDataDTO> playStrategyContext;

	@Override
	public List<HolderDataDTO> doOperationForGetAll(
			List<HolderDataDTO> origDatas) {

		return origDatas;
	}

	@Override
	public List<HolderDataDTO> doOperationForUpdate(
			List<HolderDataDTO> origDatas) {

		Debug.test(new Object() {
		}, "init", origDatas);

		playStrategyContext.setFilter(QuizPlayStrategyContextFactory.PERIOD);
		List<HolderDataDTO> executeStrategyForGetAll = playStrategyContext
				.executeStrategyForGetAll(origDatas, origDatas.size());

		List<HolderDataDTO> part1 = playStrategyContext
				.executeStrategyForUpdate(executeStrategyForGetAll);

		Debug.test(new Object() {
		}, "part1", part1);

		//差集
		List<HolderDataDTO> part2 = origDatas.stream()
				.filter(x -> !part1.contains(x)).collect(Collectors.toList());

		Debug.test(new Object() {
		}, "part2", part2);

		part2.stream().map(x -> {
			//---status 
			Status status = x.getStatus();
			status.setBeginTimeOfPhase(new Timestamp(new Date().getTime()));

			//---//status 

			FlashcardHolderDTO flashcardHolderDTO = x.getFlashcardHolderDTO();
			flashcardHolderDTO.setNumberOfQuizTimes(
					flashcardHolderDTO.getNumberOfQuizTimes() + 1);

			Flashcard flashcard = x.getFlashcardHolderDTO().getFlashcard();
			flashcard
					.setNumberOfQuizTimes(flashcard.getNumberOfQuizTimes() + 1);

			return x;
		}).collect(Collectors.toList());

		part1.addAll(part2);
		Debug.test(new Object() {
		}, "all", part1);
		List<HolderDataDTO> all = part1.stream().collect(Collectors.toList());

		Debug.test(new Object() {
		}, "distinct", all);

		return all;
	}

}
