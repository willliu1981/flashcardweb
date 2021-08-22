package com.ilan.control.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import com.ilan.control.connection.MyConnection;
import com.ilan.model.words.Testbox;

public class TestboxDao implements Dao<Testbox> {

	@Override
	public boolean add(Testbox t) {
		Connection conn = MyConnection.getConnection();

		String sql = "insert into testbox (t_id,name,testtimes,testdate,"
				+ "state,cards,create_date,update_date,creator,note,tag) values(?,?,?,?,?,?,?,?,?,?,?)";
		int r = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getT_id());
			ps.setString(2, t.getName());
			ps.setInt(3, t.getTesttimes());
			ps.setString(4, t.getTestdate());
			ps.setInt(5, t.getState());
			ps.setString(6, t.getCards());
			ps.setDate(7, t.getCreate_date());
			ps.setDate(8, t.getUpdate_date());
			ps.setString(9, t.getCreator());
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
	public Testbox queryByID(String id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Testbox queryByVocabulary(String vocabulary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Testbox> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String id, Testbox t) {
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
		Testbox box = new Testbox();
		box.setT_id("t124");
		box.setName("tb124");
		// String date=new SimpleDateFormat().format(new java.util.Date());
		// box.setTestdate(date);
		box.setCreate_date(new Date(new java.util.Date().getTime()));
		// box.setCreator("u123");

		TestboxDao dao = new TestboxDao();
		System.out.println("add:" + dao.add(box));

	}
}
