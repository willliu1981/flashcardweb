package idv.fc.quiz.strategy;

import java.util.List;
import java.util.Map;

public class QuizModStrategyContext<T> {
	private String strategy;
	private String detail;
	private Map<String, QuizStrategy<T>> strategys;

	public QuizModStrategyContext() {
		super();
	}

	public QuizModStrategyContext(Map<String, QuizStrategy<T>> strategys) {
		super();
		this.strategys = strategys;
	}

	public List<T> executeStrategy(List<T> datas, Integer num) {

		return this.strategys.get(strategy).doOperation(datas, num);
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}

}
