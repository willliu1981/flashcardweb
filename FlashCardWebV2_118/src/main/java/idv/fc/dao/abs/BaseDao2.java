package idv.fc.dao.abs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import idv.fc.model.Vocabulary;
import idv.fc.tool.SpringUtil;

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

	@Override
	public void delete(Object id) {
		String sql = String.format("delete from  %s where id=?", this.tableName);
		this.delete(id, sql);
	}

	@Override
	public T queryById(Object id) {
		String sql = String.format("select * from %s where id=?", this.tableName, id);

		Connection conn = this.getConnection();
		T model = null;
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, id.toString());
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				model = this.createModelForQuery(rs);
			}
			this.closeResources(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return model;
	}

	@Override
	public List<T> queryAll() {
		String sql = String.format("select * from %s", this.tableName);

		Connection conn = this.getConnection();
		List<T> list = new ArrayList<>();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
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

	public abstract T createModelForQuery(ResultSet rs) throws SQLException;

}
