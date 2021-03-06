package idv.fc.dao.itf;

import java.sql.SQLException;
import java.util.List;

import idv.excpetion.FindErrorException;

public interface Dao<T> {
	void create(T model) throws SQLException;

	void update(T model, Object id) throws SQLException;

	void update(T model) throws SQLException;

	void delete(Object id) throws SQLException;

	T selectById(Object id) throws SQLException;

	List<T> selectAll();

	public int executeSQL(String sql, Object... params) throws SQLException;

	public List<T> querySQL(String sql);

	public List<T> querySQL(String sql, Object... params);
}
