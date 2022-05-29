package idv.fc.quiz.strategy;

import java.util.List;

public interface QuizFilter<T> {
	List<T> doOperation(List<T> origDatas);
}
