package idv.fc.quiz.strategy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import idv.fc.model.dto.HolderDataDTO;

//@Component("quizModStrategyContextBean")
@Component("xxx")
public class QuizModStrategyContextFactory
		implements FactoryBean<QuizModStrategyContext<HolderDataDTO>> {

	@Autowired
	private PeriodStrategy periodStrategy;

	@Autowired
	private CommonStrategy commonStrategy;

	@Override
	public QuizModStrategyContext<HolderDataDTO> getObject() throws Exception {
		Map<String, QuizStrategy<HolderDataDTO>> strategys = new HashMap<>();
		strategys.put("period", periodStrategy);
		strategys.put("period", commonStrategy);

		return new QuizModStrategyContext<HolderDataDTO>(strategys);
	}

	@Override
	public Class<?> getObjectType() {
		return QuizModStrategyContext.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
