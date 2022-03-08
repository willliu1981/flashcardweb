package idv.fc.dao;

import java.util.List;

public interface IDao<T> {
	void create(T t);

	void update(T t, Object id);

	void delete(Object id);

	T queryById(Object id);

	List<T> queryAll();
	
	

}
