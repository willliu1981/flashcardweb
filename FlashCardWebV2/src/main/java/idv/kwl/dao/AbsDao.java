package idv.kwl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import idv.kwl.bean.factory.SpringUtil;
import idv.kwl.connection.DataSource;

public abstract class AbsDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		if (this.dataSource == null) {
			this.dataSource = (DataSource) SpringUtil.getBean("DataSource");
		}
		return dataSource;
	}

	protected Connection getConnection() {
		return this.getDataSource().getConnection();
	}

	protected void closeResources(Statement st, Connection conn) {
		closeResources(null, st, conn);
	}

	protected void closeResources(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			st.close();
			conn.close();
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
	}

	protected void delete(Object id, String sql) {
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

}
