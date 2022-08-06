package idv.fc.quiz.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PhaseRuleExecutor {

	@Autowired
	IPhaseRule rule;

	public boolean isValidPhase(Integer phase) {
		if (phase >= rule.getMaxLimit()) {
			return false;
		}

		return true;
	}
}
