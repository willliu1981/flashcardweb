package idv.fc.dao.abs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import idv.fc.tool.StringConstructor;

public abstract class BaseDao2<T> implements Dao<T> {
	private DataSource dataSource;
	private String tableName;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String name) {
		this.tableName = name;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	protected Connection getConnection() {
		try {
			return this.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected void closeResources(Statement st, Connection conn) {
		closeResources(null, st, conn);
	}

	protected void closeResources(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}

			if (st != null) {
				st.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void create(T model) {
		Map<String, Object> map = new HashMap<>();
		this.createMapForCreate(model, map);

		List<String> keys = new ArrayList<>();
		List<Object> values = new ArrayList<>();

		map.forEach((k, v) -> {
			keys.add(k);
			values.add(v);
		});

		String[] keyArr = keys.toArray(new String[keys.size()]);
		Object[] valueArr = values.toArray(new Object[values.size()]);

		String cols = StringConstructor.join(keyArr, ",");

		String questionMarks = StringConstructor.join("%s?", keyArr, false, ",");

		String sql = String.format("insert into %s (%s) values (%s)", this.tableName,
				cols, questionMarks);

		this.executeSQL(sql, valueArr);
	}

	@Override
	public void update(T model, Object id) {
		Map<String, Object> map = new HashMap<>();
		this.createMapForCreate(model, map);

		List<String> keys = new ArrayList<>();
		List<Object> values = new ArrayList<>();

		map.forEach((k, v) -> {
			keys.add(k);
			values.add(v);
		});

		// sql : where id=? 將id 追加到最後一個元素
		values.add(id);

		String[] keyArr = keys.toArray(new String[keys.size()]);
		Object[] valueArr = values.toArray(new Object[values.size()]);

		String fragment = StringConstructor.join("%s=?", keyArr, ",");

		String sql = String.format("update %s set %s where id=?", this.tableName,
				fragment);

		this.executeSQL(sql, valueArr);

	}

	public void delete(Object id, String sql) {
		Connection conn = this.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setObject(1, id);
			st.execute();

			this.closeResources(st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Object id) {
		String sql = String.format("delete from  %s where id=?", this.tableName);
		this.delete(id, sql);
	}

	@Override
	public T queryById(Object id) {
		String sql = String.format("select * from %s where id=?", this.tableName, id);
		return query(sql, id).get(0);
	}

	@Override
	public List<T> queryAll() {
		String sql = String.format("select * from %s", this.tableName);
		return query(sql);
	}

	public List<T> query(String sql) {
		return query(sql, null);
	}

	public List<T> query(String sql, Object id) {
		Connection conn = this.getConnection();
		List<T> list = new ArrayList<>();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			if (id != null) {
				st.setObject(1, id);
			}
			ResultSet rs = st.executeQuery();
			T model = null;
			while (rs.next()) {
				model = this.createModelForQuery(rs);
				list.add(model);
			}

			this.closeResources(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public abstract void createMapForCreate(T model, Map<String, Object> cols);

	public abstract void createMapForUpdate(T model, Map<String, Object> cols);

	public int executeSQL(String sql, Object[] params) {
		Connection conn = this.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					st.setObject(i + 1, params[i]);
				}
			}
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeResources(rs, st, conn);
		}
		return 0;
	}

	public abstract T createModelForQuery(ResultSet rs) throws SQLException;

}
