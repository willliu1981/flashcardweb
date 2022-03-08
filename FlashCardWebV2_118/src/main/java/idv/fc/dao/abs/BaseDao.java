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

public abstract class BaseDao<T> implements Dao<T> {
	private DataSource dataSource;
	private String tableName;

	protected String getTableName() {
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

	public List<T> querySQL(String sql) {
		return querySQL(sql, null);
	}

	public List<T> querySQL(String sql, Object id) {
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

	public void deleteSQL(Object id, String sql) {
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

	protected abstract void createMapForCreate(T model, Map<String, Object> cols);

	protected abstract void createMapForUpdate(T model, Map<String, Object> cols);

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

	protected abstract T createModelForQuery(ResultSet rs) throws SQLException;

}
