package idv.fc.quiz.playstrategy;

import java.util.List;

public interface QuizFilter<T> {
	List<T> doOperation(List<T> origDatas);
}
