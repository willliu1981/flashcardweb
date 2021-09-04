package com.ilan.control.dao.word;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.ilan.control.connection.MyConnection;
import com.ilan.control.factory.daofactory.AbstractDao;
import com.ilan.control.factory.daofactory.IDao;
import com.ilan.exception.ResultNullException;
import com.ilan.model.user.User;
import com.ilan.model.word.Word;

public class WordDao extends AbstractDao<Word> implements IDao<Word> {

	@Override
	public boolean add(Word t) {
		Connection conn = MyConnection.getConnection();

		String sql = "insert into word (w_id,vocabulary,translation,explanation,"
				+ "explanation2,create_date,update_date,creator,note,tag) values(?,?,?,?,?,?,?,?,?,?)";
		int r = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getW_id());
			ps.setString(2, t.getVocabulary());
			ps.setString(3, t.getTranslation());
			ps.setString(4, t.getExplanation());
			ps.setString(5, t.getExplanation2());
			ps.setDate(6, t.getCreate_date());
			ps.setDate(7, t.getUpdate_date());
			ps.setString(8, t.getCreator());
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
	public Word queryByID(String id) throws IOException {
		Connection conn = MyConnection.getConnection();

		String sql = "select * from word where w_id=?";
		Word r = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				r = new Word();
				r.setW_id(rs.getString("w_id"));
				r.setVocabulary(rs.getString("vocabulary"));
				r.setTranslation(rs.getString("translation"));
				r.setExplanation(rs.getString("explanation"));
				r.setExplanation2(rs.getString("explanation2"));
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

		if (r == null) {
			throw new ResultNullException(id);
		}

		return r;
	}

	@Override
	public List<Word> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String id, Word t) {
		Connection conn = MyConnection.getConnection();

		String sql = "update word set w_id=?,vocabulary=?,translation=?,explanation=?,"
				+ "explanation2=?,create_date=?,update_date=?,creator=?,note=?,tag=? where w_id=?";
		int r = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getW_id());
			ps.setString(2, t.getVocabulary());
			ps.setString(3, t.getTranslation());
			ps.setString(4, t.getExplanation());
			ps.setString(5, t.getExplanation2());
			ps.setDate(6, t.getCreate_date());
			ps.setDate(7, t.getUpdate_date());
			ps.setString(8, t.getCreator());
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
		Connection conn = MyConnection.getConnection();

		String sql = "delete from word where w_id=?";
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
	
	@Override
	public Word find(String sqlSegment, String... querys) throws ResultNullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void test() {
		// testAdd();
		testQueryID();
		// testUpdate();
	}

	// @Test
	public void testAdd() {
		Word w = new Word();
		w.setW_id("e138");
		w.setVocabulary("test10");
		w.setTranslation("測驗10");
		w.setExplanation("ttt1");
		w.setExplanation2("ttt2");
		w.setCreate_date(new Date(new java.util.Date().getTime()));
		w.setCreator("u123");
		w.setNote("nothing");
		w.setTag("null");

		IDao<Word> dao = new WordDao();
		System.out.println("add: " + dao.add(w));
	}

	// @Test
	public void testDel() {
		WordDao dao = new WordDao();
		System.out.println("del:" + dao.delete("e129"));

	}

	// @Test
	public void testQueryID() {
		WordDao dao = new WordDao();
		Word w;
		try {
			w = dao.queryByID("e137");
			System.out.println("query id:" + w.getW_id() + ", " + w.getVocabulary());
			System.out.println("query id:" + w.getW_id().length());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	// @Test
	public void testUpdate() {
		WordDao dao = new WordDao();
		Word w;
		try {
			w = dao.queryByID("e135");
			String id = w.getW_id();
			w.setW_id("e137");

			System.out.println("update:" + dao.update(id, w));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}


}
