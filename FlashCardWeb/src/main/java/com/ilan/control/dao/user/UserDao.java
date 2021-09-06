package com.ilan.control.dao.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ilan.control.factory.daofactory.user.IUserDao;
import com.ilan.exception.ResultNullException;
import com.ilan.model.user.User;
import com.ilan.model.user.Userdata;

public class UserDao implements IUserDao {
	protected DataSource dataSource;

	@Override
	public boolean add(User t) {
		Connection conn = null;

		String sql = "insert into user (u_id,displayname,username,password,"
				+ "authority,userdata_id, create_date,update_date,note,tag) values(?,?,?,?,?,?,?,?,?,?)";
		int r = 0;
		try {
			PreparedStatement ps = (conn = dataSource.getConnection()).prepareStatement(sql);
			ps.setString(1, t.getU_id());
			ps.setString(2, t.getDisplayName());
			ps.setString(3, t.getUsername());
			ps.setString(4, t.getPassword());
			ps.setString(5, t.getAuthority());
			ps.setString(6, t.getUserdata_id());
			ps.setDate(7, t.getCreate_date());
			ps.setDate(8, t.getUpdate_date());
			ps.setString(9, t.getNote());
			ps.setString(10, t.getTag());

			r = ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage() + " : " + this.getClass().getName() + "::add");
		}
		return r > 0 ? true : false;
	}

	@Override
	public User queryByID(String id) throws IOException, SQLException {
		User user = find("select * from user where u_id=?", id);
		if (user == null) {
			throw new ResultNullException(
					"Result is Null:" + this.getClass().getName() + "::queryByID:" + id);
		}
		return user;
	}

	@Override
	public User findByUsername(String username) throws ResultNullException, SQLException {
		User user = find("select * from user where username=?", username);
		if (user == null) {
			throw new ResultNullException("Result is Null:" + this.getClass().getName()
					+ "::queryByUsername:" + username);
		}
		return user;
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String id, User t) {
		Connection conn = null;

		String sql = "update user set u_id=?,displayname=?,username=?,password=?,authority=?,userdata_id=?,create_date=?,update_date=?,note=?,tag=? where u_id=?";
		int r = 0;
		try {
			PreparedStatement ps = (conn = dataSource.getConnection()).prepareStatement(sql);
			ps.setString(1, t.getU_id());
			ps.setString(2, t.getDisplayName());
			ps.setString(3, t.getUsername());
			ps.setString(4, t.getPassword());
			ps.setString(5, t.getAuthority());
			ps.setString(6, t.getUserdata_id());
			ps.setDate(7, t.getCreate_date());
			ps.setDate(8, t.getUpdate_date());
			ps.setString(9, t.getNote());
			ps.setString(10, t.getTag());
			ps.setString(11, id);

			r = ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage() + " : " + this.getClass().getName() + "::update");
		}

		return r;
	}

	@Override
	public int delete(String id) {
		Connection conn = null;

		String sql = "delete from user where u_id=?";
		int r = 0;
		try {
			PreparedStatement ps = (conn = dataSource.getConnection()).prepareStatement(sql);
			ps.setString(1, id);
			r = ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage() + ":" + this.getClass().getName() + "::delete:" + id);
		}

		return r;
	}

	@Override
	public User identifyUser(String username, String password)
			throws ResultNullException, SQLException {
		User user = find("select * from user where username=? and password=?", username, password);
		if (user == null) {
			throw new ResultNullException(this.getClass(), "identifyUser",
					String.format("username=%s,password=%s", username, password));
		}
		return user;
	}

	@Override
	public User find(String sqlSegment, String... querys) throws ResultNullException, SQLException {
		Connection conn = null;
		User r = null;
		try {
			PreparedStatement ps = (conn = dataSource.getConnection()).prepareStatement(sqlSegment);
			for (int idx = 0; idx < querys.length; idx++) {
				ps.setString(idx + 1, querys[idx]);
			}

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				r = new User();
				r.setU_id(rs.getString("u_id"));
				r.setDisplayName(rs.getString("displayname"));
				r.setUsername(rs.getString("username"));
				r.setPassword(rs.getString("password"));
				r.setAuthority(rs.getString("authority"));
				r.setUserdata_id(rs.getString("userdata_id"));
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
	public void setDefaultAuthority() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;

	}

	@Test
	public void test() {
		new TestCls().testUpdate();
	}

	class TestCls {

		// @Test
		public void test() {
			// testAdd();
			testUpdate();
			// testDel();
			// testAddAndUpdate();
		}

		// @Test
		public void testAdd() {
			User user = new User();
			user.setU_id("u123");
			user.setDisplayName("Tony");
			user.setUsername("tony123");
			user.setPassword("t1234");
			user.setUserdata_id("temp_u123");

			user.setCreate_date(new Date(new java.util.Date().getTime()));

			UserDao dao = new UserDao();
			System.out.println("add:" + dao.add(user));

		}

		// @Test
		public void testUpdate() {
			UserDao dao = new UserDao();
			User user;
			try {
				user = dao.queryByID("uid1629796406740");
				String id = user.getU_id();
//				user.setDisplayName("Tony");
//				user.setUsername("tony123");
				user.setPassword("mm123456");
				// user.setUserdata_id("ud256");

				user.setCreate_date(new Date(new java.util.Date().getTime()));

				System.out.println("update:" + dao.update(id, user));
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// @Test
		public void testDel() {
			UserDao dao = new UserDao();
			System.out.println("del:" + dao.delete("uid1629951570073"));

		}

		// @Test
		public void testAddAndUpdate() {
			UserDao daoUser = new UserDao();
			UserdataDao daoUserdata = new UserdataDao();

			String userID = "u125";
			String userdataID = "ud999";

			// create user
			User user = new User();
			user.setU_id(userID);
			user.setDisplayName("Kevin");
			user.setUsername("kevin123");
			user.setPassword("k1234");
			user.setUserdata_id(userdataID);

			daoUser.add(user);

			// create userdata
			Userdata userdata = new Userdata();
			userdata.setUd_id(userdataID);
			userdata.setUser_id(user.getU_id());
			userdata.setName(user.getDisplayName());
			userdata.setEmail("kevin123@yahoo.com.tw");

			try {
				daoUserdata.add(userdata);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
