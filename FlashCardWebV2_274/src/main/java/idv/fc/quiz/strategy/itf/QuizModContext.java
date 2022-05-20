package idv.fc.quiz.strategy.itf;

import java.util.List;

public class QuizModContext<T> {
	private QuizStrategy<T> strategy;
	private List<T> datas;

	public QuizModContext(List<T> datas) {
		super();
		this.datas = datas;
	}

	public List<T> executeStrategy(String mod, Integer num) {
		return this.strategy.doOperation(datas, mod, num);
	}

	public void setStrategy(QuizStrategy<T> strategy) {
		this.strategy = strategy;
	}

}
