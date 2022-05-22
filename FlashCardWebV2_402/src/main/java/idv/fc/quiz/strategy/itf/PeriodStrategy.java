package idv.fc.quiz.strategy.itf;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import idv.fc.model.dto.HolderDataDTO;

public class PeriodStrategy implements QuizStrategy<HolderDataDTO> {

	@Override
	public List<HolderDataDTO> doOperation(List<HolderDataDTO> origDatas,
			String mod, Integer num) {
		List<HolderDataDTO> filterTime = origDatas.stream().filter(x -> {
			if (x.getStatus().getEndTimeOfPhase() == null) {
				return true;
			}
			return x.getStatus().getEndTimeOfPhase().before(new Date());
		}).collect(Collectors.toList());

		return filterTime.stream().collect(
				Collectors.collectingAndThen(Collectors.toList(), collected -> {
					Collections.shuffle(collected);
					return collected.stream();
				})).limit(num).collect(Collectors.toList());
	}

}
