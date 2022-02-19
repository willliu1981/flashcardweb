package idv.kwl.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import idv.kwl.component.SpringUtil;
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
		try {
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
