package idv.kwl.handle.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import idv.kwl.component.SpringUtil;
import idv.kwl.connection.DataSource;

public abstract class AbsDao {
	private DataSource dataSource = (DataSource) SpringUtil.getBean("dataSource");

	protected Connection getConnection() {
		return this.dataSource.getConnection();
	}
	
	protected void closeResources(Statement st,Connection conn) {
		 try {
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
