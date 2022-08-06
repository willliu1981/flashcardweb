package idv.fc.quiz.playstrategy;

import java.util.List;

public interface QuizFilter<T> {
	List<T> doOperationForGetAll(List<T> origDatas);
	List<T> doOperationForUpdate(List<T> origDatas);
}
