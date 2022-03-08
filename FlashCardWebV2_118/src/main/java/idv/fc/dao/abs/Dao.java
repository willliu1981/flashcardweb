package idv.fc.dao.abs;

import java.util.List;

public interface Dao<T> {
	void create(T t);

	void update(T t, Object id);

	void delete(Object id);

	T queryById(Object id);

	List<T> queryAll();
	
	

}
