package idv.fc.quiz.phasestrategy;

import java.sql.Timestamp;

import idv.fc.quiz.phaseexception.QuizPhaseInvalidException;

public interface IPhaseStrategy {
	Timestamp doOperation(Timestamp priTime,Integer currentPhase) throws QuizPhaseInvalidException;
}
