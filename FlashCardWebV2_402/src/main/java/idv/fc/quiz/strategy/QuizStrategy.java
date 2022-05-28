package idv.fc.quiz.strategy;

import java.util.List;

public interface QuizStrategy<T> {
	List<T> doOperation(List<T> origDatas, String mod, Integer num);
}
