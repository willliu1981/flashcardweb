package idv.fc.quiz.strategy.itf;

import java.util.List;

public interface QuizStrategy<T> {
	List<T> doOperation(List<T> origDatas, String mod, Integer num);
}
