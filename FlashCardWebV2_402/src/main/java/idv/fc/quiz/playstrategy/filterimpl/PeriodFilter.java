package idv.fc.quiz.playstrategy.filterimpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import idv.fc.model.dto.HolderDataDTO;
import idv.fc.quiz.playstrategy.QuizFilter;
import idv.fc.quiz.strategy.PhaseRuleExecutor;

@Repository("periodFilter")
public class PeriodFilter implements QuizFilter<HolderDataDTO> {
	@Autowired
	private PhaseRuleExecutor re;

	@Override
	public List<HolderDataDTO> doOperation(List<HolderDataDTO> origDatas) {

		List<HolderDataDTO> filterTime = origDatas.stream().filter(x -> {

			if (!re.isValidPhase(x.getStatus().getPhase())) {
				return false;
			}

			if (x.getStatus().getEndTimeOfPhase() == null) {
				return true;
			}

			boolean before = x.getStatus().getEndTimeOfPhase()
					.before(new Date());

			return before;
		}).collect(Collectors.toList());

		return filterTime;
	}

}
