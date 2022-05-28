package idv.fc.quiz.strategy;

import org.springframework.beans.factory.FactoryBean;


public class QuizModCommonStrategyBean implements FactoryBean<QuizStrategy> {

	@Override
	public QuizStrategy getObject() throws Exception {
		return new CommonStrategy();
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}

}
