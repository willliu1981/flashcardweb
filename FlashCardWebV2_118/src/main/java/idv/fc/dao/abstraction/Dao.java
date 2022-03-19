package idv.fc.dao.abstraction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import idv.fc.exception.FindErrorException;

public interface Dao<T> {
	void create(T model) throws SQLException;

	void update(T model, Object id) throws SQLException;

	void delete(Object id);

	T queryById(Object id) throws FindErrorException;

	List<T> queryAll();

	public int executeSQL(String sql, Object... params) throws SQLException;

	public List<T> querySQL(String sql);

	public List<T> querySQL(String sql, Object... params);
}
