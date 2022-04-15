package idv.fc.dao.abstraction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public abstract class OldBaseDao{
	private DataSource dataSource;
	private String tableName;

	public String getTableName() {
		return tableName;
	}

	protected void setTableName(String name) {
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
			st.close();
			conn.close();
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
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

	public void delete(Object id) {
		String sql = String.format("delete from  %s where id=?", this.tableName);
		this.delete(id, sql);
	}
	


}
