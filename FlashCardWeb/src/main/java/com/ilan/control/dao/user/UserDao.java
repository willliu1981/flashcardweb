package com.ilan.control.dao.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.ilan.control.connection.MyConnection;
import com.ilan.control.dao.Dao;
import com.ilan.control.dao.word.TestboxDao;
import com.ilan.model.user.User;
import com.ilan.model.word.Testbox;

public class UserDao implements Dao<User> {

	@Override
	public boolean add(User t) {
		Connection conn = MyConnection.getConnection();

		String sql = "insert into user (u_id,displayname,username,password,"
				+ "email,authority,userdata, create_date,update_date,note,tag) values(?,?,?,?,?,?,?,?,?,?,?)";
		int r = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getU_id());
			ps.setString(2, t.getDisplayName());
			ps.setString(3, t.getUsername());
			ps.setString(4, t.getPassword());
			ps.setString(5, t.getEmail());
			ps.setString(6, t.getAuthority());
			ps.setString(7, t.getUserdata());
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Test
	public void test() {
		testAdd();
	}

	// @Test
	public void testAdd() {
		User user = new User();
		user.setU_id("u130");
		user.setDisplayName("Tony");
		user.setUsername("tony123");
		user.setPassword("t1234");
		user.setEmail("tony123@yahoo.com.tw");
		user.setUserdata("ud123");

		user.setCreate_date(new Date(new java.util.Date().getTime()));


		UserDao dao = new UserDao();
		System.out.println("add:" + dao.add(user));

	}

}
