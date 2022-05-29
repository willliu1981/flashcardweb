package idv.fc.quiz.strategy.modimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import idv.fc.model.dto.HolderDataDTO;
import idv.fc.quiz.strategy.QuizMod;

@Repository("timeMod")
public class TimeMod implements QuizMod<HolderDataDTO> {

	@Override
	public List<HolderDataDTO> doOperation(List<HolderDataDTO> origDatas,
			Integer num) {

		List<HolderDataDTO> collect = origDatas.stream().sorted((x1, x2) -> {
			if (x1.getStatus().getBeginTimeOfPhase()
					.equals(x2.getStatus().getBeginTimeOfPhase())) {
				return 0;
			}

			boolean before = x1.getStatus().getBeginTimeOfPhase()
					.before(x2.getStatus().getBeginTimeOfPhase());

			return before ? -1 : 1;
		}).limit(num).collect(Collectors.toList());

		return collect;
	}

}
