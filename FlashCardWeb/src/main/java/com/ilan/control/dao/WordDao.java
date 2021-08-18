package com.ilan.control.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.ilan.control.connection.MyConnection;
import com.ilan.model.words.Word;

public class WordDao implements Dao<Word> {

	@Override
	public boolean add(Word t) {
		Connection conn = MyConnection.getConnection();

		String sql = "insert into word (w_id,vocabulary,translation,explanation,"
				+ "explanation2,create_date,update_date,creator,note,tag) values(?,?,?,?,?,?,?,?,?,?)";
		boolean r = false;
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

			r = ps.execute();

			ps.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;
	}

	@Override
	public Word queryByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Word queryByVocabulary(String vocabulary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Word> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String id, Word t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Test
	public void testAdd() {
		Word w = new Word();
		w.setW_id("e127");
		w.setVocabulary("test3");
		w.setTranslation("測驗3");
		w.setExplanation("ttt1");
		w.setExplanation2("ttt2");
		w.setCreate_date(new Date(new java.util.Date().getTime()));
		w.setCreator("u123");
		w.setNote("nothing");
		w.setTag("null");

		Dao<Word> dao = new WordDao();
		System.out.println("result: " + dao.add(w));
	}

}
