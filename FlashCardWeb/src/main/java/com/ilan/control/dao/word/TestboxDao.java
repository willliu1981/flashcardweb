package com.ilan.control.dao.word;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import com.ilan.control.connection.MyConnection;
import com.ilan.control.dao.Dao;
import com.ilan.model.word.Card;
import com.ilan.model.word.Testbox;

public class TestboxDao implements Dao<Testbox> {

	@Override
	public boolean add(Testbox t) {
		Connection conn = MyConnection.getConnection();

		boolean flag1 = t.getTesttimes() != null;
		boolean flag2 = t.getState() != null;
		String keys = String.format(
				"insert into testbox (t_id,name,%s testdate,%s cards,create_date,update_date,creator,note,tag)",
				flag1 ? "testtimes," : "", flag2 ? "state," : "");

		String values = String.format("values(%s%s?,?,?,?,?,?,?,?,?)", flag1 ? "?," : "", flag2 ? "?," : "");

		String sql = keys + values;

		int r = 0;
		try {
			int idx = 1;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(idx++, t.getT_id());
			ps.setString(idx++, t.getName());
			if (flag1)
				ps.setInt(idx++, t.getTesttimes());
			ps.setTimestamp(idx++, t.getTestdate());
			if (flag2)
				ps.setInt(idx++, t.getState());
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
		Connection conn = MyConnection.getConnection();

		String sql = "select * from testbox where t_id=?";
		Testbox r = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				r = new Testbox();
				r.setT_id(rs.getString("t_id"));
				r.setName(rs.getString("name"));
				r.setTesttimes(rs.getInt("testtimes"));
				r.setTestdate(rs.getTimestamp("testdate"));
				r.setState(rs.getInt("state"));
				r.setCards(rs.getString("cards"));
				r.setCreate_date(rs.getDate("create_date"));
				r.setUpdate_date(rs.getDate("update_date"));
				r.setCreator(rs.getString("creator"));
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
	public List<Testbox> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String id, Testbox t) {
		Connection conn = MyConnection.getConnection();

		boolean flag1 = t.getTesttimes() != null;
		boolean flag2 = t.getState() != null;
		String sql = String
				.format("update testbox set t_id=?,name=?,%s testdate=?,%s cards=?,create_date=?,update_date=?,"
						+ "creator=?,note=?,tag=? where t_id=?", flag1 ? "testtimes=?," : "", flag2 ? "state=?," : "");
		int r = 0;
		try {
			int idx = 1;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(idx++, t.getT_id());
			ps.setString(idx++, t.getName());
			if (flag1)
				ps.setInt(idx++, t.getTesttimes());
			ps.setTimestamp(idx++, t.getTestdate());
			if (flag2)
				ps.setInt(idx++, t.getState());
			ps.setString(idx++, t.getCards());
			ps.setDate(idx++, t.getCreate_date());
			ps.setDate(idx++, t.getUpdate_date());
			ps.setString(idx++, t.getCreator());
			ps.setString(idx++, t.getNote());
			ps.setString(idx++, t.getTag());
			ps.setString(idx++, id);

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Test
	public void test() {
		// testAdd();
		testUpdate();
	}

	// @Test
	public void testAdd() {
		Testbox box = new Testbox();
		box.setT_id("t138");
		box.setName("tb138");
		box.setTestdate(new Timestamp(new java.util.Date().getTime()));
		box.setCreate_date(new Date(new java.util.Date().getTime()));
		box.setCreator("u123");
		box.setNote("test測試2");
		box.setTesttimes(3);
		box.setState(4);

		TestboxDao dao = new TestboxDao();
		System.out.println("add:" + dao.add(box));

	}

	// @Test
	public void testUpdate() {
		TestboxDao dao = new TestboxDao();
		Testbox box;
		try {
			box = dao.queryByID("t138");
			String id = box.getT_id();
			// box.setT_id("t137");
			// box.setName("tb137");
			box.setTestdate(new Timestamp(new java.util.Date().getTime()));
			box.setUpdate_date(new Date(new java.util.Date().getTime()));
			// box.setCreate_date(new Date(new java.util.Date().getTime()));
			// box.setCreator("u123");
			// box.setNote("test測試2");
			box.setTesttimes(0);
			box.setState(0);

			System.out.println("update:" + dao.update(id, box));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
