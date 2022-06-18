package idv.fc.quiz.playstrategy;

import java.util.List;
import java.util.Map;

import idv.debug.Debug;

public class QuizPlayStrategyContext<T> {
	private String filter;
	private String mod = "default";
	private Map<String, QuizFilter<T>> fliters;
	private Map<String, QuizMod<T>> mods;

	public QuizPlayStrategyContext() {
		super();
	}

	public QuizPlayStrategyContext(Map<String, QuizFilter<T>> fliters,
			Map<String, QuizMod<T>> mods) {
		super();
		this.fliters = fliters;
		this.mods = mods;
	}

	//datas: primary datas
	public List<T> executeStrategyForGetAll(List<T> datas, Integer num) {
		List<T> fliterResults = this.fliters.get(filter)
				.doOperationForGetAll(datas);
		List<T> modResults = this.mods.get(mod).doOperation(fliterResults, num);
		return modResults;
	}

	//datas: datas of result
	public List<T> executeStrategyForUpdate(List<T> datas) {
		List<T> fliterResults = this.fliters.get(filter)
				.doOperationForUpdate(datas);
		return fliterResults;
	}

	public void setFilter(String strategy) {
		this.filter = strategy;
	}

	public void setMod(String detail) {
		this.mod = detail;
	}

}
