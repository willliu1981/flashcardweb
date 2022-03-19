package idv.fc.dao.abstraction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import idv.fc.tool.Debug;

public abstract class BaseDao<T> implements Dao<T> {
	private DataSource dataSource;

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

	public void deleteSQL(String sql, Object id) {
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
	public int executeSQL(String sql, Object... params) throws SQLException {
		Connection conn = this.getConnection();
		PreparedStatement st = null;
		int r = 0;
		try {
			st = conn.prepareStatement(sql);
			prepareStatementSetObjects(st, params);
			r = st.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			this.closeResources(st, conn);
		}

		return r;
	}

	protected void prepareStatementSetObjects(PreparedStatement st, Object... params) {
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				try {
					st.setObject(i + 1, params[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<T> querySQL(String sql) {
		throw new UnsupportedOperationException(
				String.format("%s:\"%s\"", this.getClass(), sql));
	}

	@Override
	public List<T> querySQL(String sql, Object... params) {
		throw new UnsupportedOperationException(
				String.format("%s:\"%s\"", this.getClass(), sql));
	}

}
