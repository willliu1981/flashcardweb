package idv.fc.dao.abstraction;

import java.sql.ResultSet;
import java.util.List;

public interface Dao<T> {
	void create(T model);

	void update(T model, Object id);

	void delete(Object id);

	T queryById(Object id);

	List<T> queryAll();

	public int executeSQL(String sql, Object... params);

	public List<T> querySQL(String sql);

	public List<T> querySQL(String sql,  Object... params);
}
