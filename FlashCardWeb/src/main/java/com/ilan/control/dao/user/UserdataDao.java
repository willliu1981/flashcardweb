package com.ilan.control.dao.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ilan.control.connection.MyConnection;
import com.ilan.control.factory.daofactory.AbstractDao;
import com.ilan.control.factory.daofactory.user.IUserdataDao;
import com.ilan.exception.ResultNullException;
import com.ilan.model.user.Userdata;

public class UserdataDao extends AbstractDao<Userdata> implements IUserdataDao {
	@Autowired
	protected DataSource dataSource;
	
	@Override
	public boolean add(Userdata t) throws SQLException {
		Connection conn = dataSource.getConnection();

		String sql = "insert into userdata (ud_id,user_id,name,email,cardboxdata,scenedata,"
				+ "create_date,update_date,note,tag) values(?,?,?,?,?,?,?,?,?,?)";
		int r = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getUd_id());
			ps.setString(2, t.getUser_id());
			ps.setString(3, t.getName());
			ps.setString(4, t.getEmail());
			ps.setString(5, t.getCardboxdata());
			ps.setString(6, t.getScenedata());
			ps.setDate(7, t.getCreate_date());
			ps.setDate(8, t.getUpdate_date());
			ps.setString(9, t.getNote());
			ps.setString(10, t.getTag());

			r = ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage() + " : " + this.getClass().getName() + "::add");
		}

		return r > 0 ? true : false;
	}

	@Override
	public Userdata queryByID(String id) throws IOException, SQLException {
		Userdata data = find("select * from userdata where ud_id=?", id);
		if (data == null) {
			throw new ResultNullException(
					"Result is Null:" + this.getClass().getName() + "::queryByID:" + id);
		}
		return data;
	}

	@Override
	public List<Userdata> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String id, Userdata t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Userdata find(String sqlSegment, String... querys)
			throws ResultNullException, SQLException {
		//Connection conn = this.getDataSource().getConnection();
		Connection conn = dataSource.getConnection();
		String sql = sqlSegment;
		Userdata r = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int idx = 0; idx < querys.length; idx++) {
				ps.setString(idx + 1, querys[idx]);
			}

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				r = new Userdata();
				r.setUd_id(rs.getString("ud_id"));
				r.setUser_id(rs.getString("user_id"));
				r.setName(rs.getString("name"));
				r.setEmail(rs.getString("email"));
				r.setCardboxdata(rs.getString("cardboxdata"));
				r.setScenedata(rs.getString("scenedata"));
				r.setCreate_date(rs.getDate("create_date"));
				r.setUpdate_date(rs.getDate("update_date"));
				r.setNote(rs.getString("note"));
				r.setTag(rs.getString("tag"));
			}

			ps.close();
			conn.close();

		} catch (SQLException e) {
			System.out.println(
					e.getMessage() + " : " + this.getClass().getName() + "::find:" + sqlSegment);
		}

		return r;
	}

	@Override
	public Userdata findByEmail(String email) throws ResultNullException, SQLException {
		Userdata data = this.find("", email);
		if (data == null) {
			throw new ResultNullException(
					"Result is Null:" + this.getClass().getName() + "::findByEmail:" + email);
		}
		return data;
	}

	@Test
	public void test() {
		testAdd();
	}

	// @Test
	public void testAdd() {
		Userdata data = new Userdata();
		data.setUd_id("ud256");
		data.setUser_id("u123");

		UserdataDao dao = new UserdataDao();
		try {
			System.out.println("add:" + dao.add(data));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
