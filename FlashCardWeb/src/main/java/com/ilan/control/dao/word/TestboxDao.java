package com.ilan.control.dao.word;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import com.ilan.control.connection.MyConnection;
import com.ilan.control.dao.Dao;
import com.ilan.model.word.Testbox;

public class TestboxDao implements Dao<Testbox> {

	@Override
	public boolean add(Testbox t) {
		Connection conn = MyConnection.getConnection();

		String keys = String.format(
				"insert into testbox (t_id,name,%s testdate,%s cards,create_date,update_date,creator,note,tag)",
				t.getTesttimes() != null ? "testtimes," : "", t.getState() != null ? "state," : "");
		String values = String.format("values(%s%s?,?,?,?,?,?,?,?,?)", t.getTesttimes() != null ? "?," : "",
				t.getState() != null ? "?," : "");
		String sql = keys + values;

		int r = 0;
		try {
			int idx = 1;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(idx++, t.getT_id());
			ps.setString(idx++, t.getName());
			if (t.getTesttimes() != null) {
				ps.setInt(idx++, t.getTesttimes());
			}
			ps.setString(idx++, t.getTestdate());
			if (t.getState() != null) {
				ps.setInt(idx++, t.getState());
			}
			ps.setString(idx++, t.getCards());
			ps.setDate(idx++, t.getCreate_date());
			ps.setDate(idx++, t.getUpdate_date());
			ps.setString(idx++, t.getCreator());
			ps.setString(idx++, t.getNote());
			ps.setString(idx++, t.getTag());

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
		box.setT_id("t137");
		box.setName("tb137");
		// String date=new SimpleDateFormat().format(new java.util.Date());
		// box.setTestdate(date);
		box.setCreate_date(new Date(new java.util.Date().getTime()));
		box.setCreator("u123");
		box.setNote("test測試2");
		box.setTesttimes(3);
		box.setState(4);

		TestboxDao dao = new TestboxDao();
		System.out.println("add:" + dao.add(box));

	}

}
