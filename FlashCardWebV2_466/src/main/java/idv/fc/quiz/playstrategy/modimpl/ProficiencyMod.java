package idv.fc.quiz.playstrategy.modimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import idv.fc.model.dto.HolderDataDTO;
import idv.fc.quiz.playstrategy.QuizMod;

@Repository("proficiencyMod")
public class ProficiencyMod implements QuizMod<HolderDataDTO> {

	@Override
	public List<HolderDataDTO> doOperation(List<HolderDataDTO> origDatas,
			Integer num) {

		List<HolderDataDTO> collect = origDatas.stream().sorted((x1, x2) -> {

			double p1 = 0, p2 = 0;

			if (x1.getFlashcardHolderDTO().getNumberOfQuizTimes() == 0) {
				return -1;
			} else if (x2.getFlashcardHolderDTO().getNumberOfQuizTimes() == 0) {
				return -1;
			}

			p1 = x1.getFlashcardHolderDTO().getPassTheQuizTimes() / (double) x1
					.getFlashcardHolderDTO().getNumberOfQuizTimes();

			p2 = x2.getFlashcardHolderDTO().getPassTheQuizTimes() / (double) x2
					.getFlashcardHolderDTO().getNumberOfQuizTimes();

			if (p1 == p2) {
				return 0;
			}

			return p1 < p2 ? -1 : 1;
		}).limit(num).collect(Collectors.toList());

		return collect;
	}

}
