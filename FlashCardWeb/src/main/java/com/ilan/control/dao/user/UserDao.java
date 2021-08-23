package com.ilan.control.dao.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.ilan.control.connection.MyConnection;
import com.ilan.control.dao.Dao;
import com.ilan.control.dao.word.TestboxDao;
import com.ilan.control.dao.word.WordDao;
import com.ilan.model.user.User;
import com.ilan.model.user.Userdata;
import com.ilan.model.word.Testbox;

public class UserDao implements Dao<User> {

	@Override
	public boolean add(User t) {
		Connection conn = MyConnection.getConnection();

		String sql = "insert into user (u_id,displayname,username,password,"
				+ "email,authority,userdata_id, create_date,update_date,note,tag) values(?,?,?,?,?,?,?,?,?,?,?)";
		int r = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getU_id());
			ps.setString(2, t.getDisplayName());
			ps.setString(3, t.getUsername());
			ps.setString(4, t.getPassword());
			ps.setString(5, t.getEmail());
			ps.setString(6, t.getAuthority());
			ps.setString(7, t.getUserdata_id());
			ps.setDate(8, t.getCreate_date());
			ps.setDate(9, t.getUpdate_date());
			ps.setString(10, t.getNote());
			ps.setString(11, t.getTag());

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
	public User queryByID(String id) throws IOException {
		Connection conn = MyConnection.getConnection();

		String sql = "select * from user where u_id=?";
		User r = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				r = new User();
				r.setU_id(rs.getString("u_id"));
				r.setDisplayName(rs.getString("displayname"));
				r.setUsername(rs.getString("username"));
				r.setPassword(rs.getString("password"));
				r.setEmail(rs.getString("email"));
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
			// e.printStackTrace();
			System.out.println(e.getMessage() + " : " + this.getClass().getName() + "::queryByID");
		}

		return r;
	}

	@Override
	public User queryByVocabulary(String vocabulary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String id, User t) {
		Connection conn = MyConnection.getConnection();

		String sql = "update user set u_id=?,displayname=?,username=?,password=?,email=?,authority=?,"
				+ "userdata_id=?,create_date=?,update_date=?,note=?,tag=? where u_id=?";
		int r = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getU_id());
			ps.setString(2, t.getDisplayName());
			ps.setString(3, t.getUsername());
			ps.setString(4, t.getPassword());
			ps.setString(5, t.getEmail());
			ps.setString(6, t.getAuthority());
			ps.setString(7, t.getUserdata_id());
			ps.setDate(8, t.getCreate_date());
			ps.setDate(9, t.getUpdate_date());
			ps.setString(10, t.getNote());
			ps.setString(11, t.getTag());
			ps.setString(12, id);

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
		Connection conn = MyConnection.getConnection();

		String sql = "delete from user where u_id=?";
		int r = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			r = ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage() + " : " + this.getClass().getName() + "::delete");
		}

		return r;
	}

	@Test
	public void test() {
		// testAdd();
		// testUpdate();
		//testDel();
		testAddAndUpdate();
	}

	// @Test
	public void testAdd() {
		User user = new User();
		user.setU_id("u123");
		user.setDisplayName("Tony");
		user.setUsername("tony123");
		user.setPassword("t1234");
		user.setEmail("tony123@yahoo.com.tw");
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
			user = dao.queryByID("u123");
			String id = user.getU_id();
//				user.setDisplayName("Tony");
//				user.setUsername("tony123");
//				user.setPassword("t1234");
//				user.setEmail("tony123@yahoo.com.tw");
			user.setUserdata_id("ud256");

			user.setCreate_date(new Date(new java.util.Date().getTime()));

			System.out.println("update:" + dao.update(id, user));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// @Test
	public void testDel() {
		UserDao dao = new UserDao();
		System.out.println("del:" + dao.delete("u124"));

	}

	// @Test
	public void testAddAndUpdate() {
		UserDao daoUser = new UserDao();
		UserdataDao daoUserdata = new UserdataDao();

		// create user
		User user = new User();
		user.setU_id("u124");
		user.setDisplayName("Mary");
		user.setUsername("mary123");
		user.setPassword("m1234");
		user.setEmail("mary246@yahoo.com.tw");
		user.setUserdata_id("temp_" + user.getU_id());

		daoUser.add(user);

		// create userdata
		Userdata userdata = new Userdata();
		userdata.setUd_id("ud512");
		userdata.setUser_id(user.getU_id());

		daoUserdata.add(userdata);

		// update user -> userdata_id
		User newUser = new User();
		try {
			newUser = daoUser.queryByID(user.getU_id());
			newUser.setUserdata_id(userdata.getUd_id());
			daoUser.update(newUser.getU_id(), newUser);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
