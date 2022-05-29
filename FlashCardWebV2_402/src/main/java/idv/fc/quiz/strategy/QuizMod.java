package idv.fc.quiz.strategy;

import java.util.List;

public interface QuizMod<T> {
	List<T> doOperation(List<T> origDatas, Integer num);
}
