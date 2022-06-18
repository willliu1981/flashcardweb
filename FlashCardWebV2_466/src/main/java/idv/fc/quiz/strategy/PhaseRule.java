package idv.fc.quiz.strategy;

import org.springframework.stereotype.Repository;

@Repository
public class PhaseRule   implements IPhaseRule {

	@Override
	public Integer getMaxLimit() {
		return 5;
	}


	
}
