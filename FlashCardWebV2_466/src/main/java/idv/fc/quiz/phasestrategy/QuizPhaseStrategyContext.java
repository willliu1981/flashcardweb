package idv.fc.quiz.phasestrategy;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import idv.fc.quiz.phaseexception.QuizPhaseInvalidException;

@Repository
public class QuizPhaseStrategyContext {
	@Autowired
	private IPhaseStrategy strategy;

	public QuizPhaseStrategyContext(IPhaseStrategy strategy) {
		this.strategy = strategy;
	}

	public Timestamp executeStrategy(Timestamp priTime, Integer currentPhase) throws QuizPhaseInvalidException {
		return this.strategy.doOperation(priTime, currentPhase);
	}
}
