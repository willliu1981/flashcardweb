package idv.fc.quiz.strategy;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import idv.debug.Debug;
import idv.fc.model.dto.HolderDataDTO;

@Repository( "periodStrategy")
public class PeriodStrategy implements QuizStrategy<HolderDataDTO> {

	@Override
	public List<HolderDataDTO> doOperation(List<HolderDataDTO> origDatas,
			Integer num) {

		List<HolderDataDTO> filterTime = origDatas.stream().filter(x -> {
			if (x.getStatus().getEndTimeOfPhase() == null) {
				return true;
			}

			boolean before = x.getStatus().getEndTimeOfPhase()
					.before(new Date());

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
