package idv.fc.quiz.strategy;

import java.util.List;
import java.util.Map;

public class QuizModStrategyContext<T> {
	private String filter;
	private String mod;
	private Map<String, QuizFilter<T>> fliters;
	private Map<String, QuizMod<T>> mods;

	public QuizModStrategyContext() {
		super();
	}

	public QuizModStrategyContext(Map<String, QuizFilter<T>> fliters,
			Map<String, QuizMod<T>> mods) {
		super();
		this.fliters = fliters;
		this.mods = mods;
	}

	public List<T> executeStrategy(List<T> datas, Integer num) {
		List<T> fliterResults = this.fliters.get(filter).doOperation(datas);
		List<T> modResults = this.mods.get(mod).doOperation(fliterResults, num);
		return modResults;
	}

	public void setFilter(String strategy) {
		this.filter = strategy;
	}

	public void setMod(String detail) {
		this.mod = detail;
	}

}
