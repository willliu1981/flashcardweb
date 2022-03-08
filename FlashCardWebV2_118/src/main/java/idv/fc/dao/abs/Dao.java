package idv.fc.dao.abs;

import java.util.List;

public interface Dao<T> {
	void create(T model);

	void update(T model, Object id);

	void delete(Object id);

	T queryById(Object id);

	List<T> queryAll();

}
