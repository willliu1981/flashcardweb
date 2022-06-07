package idv.fc.quiz.phasestrategy.phaseimpl;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import idv.CC;
import idv.debug.Debug;
import idv.fc.quiz.phaseexception.QuizPhaseInvalidException;
import idv.fc.quiz.phasestrategy.IPhaseStrategy;
import idv.fc.quiz.strategy.PhaseRuleExecutor;

@Repository
public class PhaseStrategy implements IPhaseStrategy {
	@Autowired
	private PhaseRuleExecutor re;

	@Override
	public Timestamp doOperation(Timestamp priTime, Integer currentPhase)
			throws QuizPhaseInvalidException {
		if (!re.isValidPhase(currentPhase)) {
			throw new QuizPhaseInvalidException();
		}

		Timestamp newTime = null;
		ZonedDateTime zoneTime = priTime.toInstant().atZone(ZoneId.of("UTC"));
		
		switch (currentPhase) {
		case 0:
		case 1:
			newTime = Timestamp
					.from(zoneTime.plus(2, ChronoUnit.DAYS).toInstant());
			break;
		case 2:
			newTime = Timestamp
					.from(zoneTime.plus(7, ChronoUnit.DAYS).toInstant());
			break;
		case 3:
			newTime = Timestamp
					.from(zoneTime.plus(15, ChronoUnit.DAYS).toInstant());
			break;
		case 4:
		default:
			newTime = Timestamp
					.from(zoneTime.plus(30, ChronoUnit.DAYS).toInstant());
			break;
		}

		return newTime;
	}

}
