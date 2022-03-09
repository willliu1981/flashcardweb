package idv.fc.dao.abs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

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

	@Override
	public int executeSQL(String sql, Object... params) {
		Connection conn = this.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			prepareStatementSetObjects(st, params);
			rs = st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeResources(rs, st, conn);
		}

		return 0;
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
