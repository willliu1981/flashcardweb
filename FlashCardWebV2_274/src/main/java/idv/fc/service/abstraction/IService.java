package idv.fc.service.abstraction;

import java.util.List;

public interface IService<T> {
	public List<T> getAll();

	T getById(String id);

	public void addNew(T flashcard);

	public void edit(T flashcard);

	public void remove(String id);


}
