package idv.kwl.handle.dao;

public interface IDao<T> {
	void create(T t);

	void update(T t, Object id);
}
