package idv.fc.quiz.strategy.itf;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import idv.debug.Debug;
import idv.fc.model.dto.HolderDataDTO;

public class PeriodStrategy implements QuizStrategy<HolderDataDTO> {

	@Override
	public List<HolderDataDTO> doOperation(List<HolderDataDTO> origDatas,
			String mod, Integer num) {

		List<HolderDataDTO> filterTime = origDatas.stream().filter(x -> {
			if (x.getStatus().getEndTimeOfPhase() == null) {
				return true;
			}

			boolean before = x.getStatus().getEndTimeOfPhase()
					.before(new Date());

			Debug.test(new Object() {
			}, "test#");
			return true;//test
		}).collect(Collectors.toList());

		List<HolderDataDTO> collect = filterTime.stream().collect(
				Collectors.collectingAndThen(Collectors.toList(), collected -> {
					Collections.shuffle(collected);
					return collected.stream();
				})).limit(num).collect(Collectors.toList());

		return collect;
	}

}
