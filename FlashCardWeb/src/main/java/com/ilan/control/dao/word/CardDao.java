package com.ilan.control.dao.word;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;

import com.ilan.control.factory.daofactory.IDao;
import com.ilan.exception.ResultNullException;
import com.ilan.model.word.Card;

public class CardDao implements IDao<Card> {
	protected DataSource dataSource;

	@Override
	public boolean add(Card t) {
		Connection conn = null;

		String sql = "insert into card (c_id,word_id,name,referred,create_date,update_date,"
				+ "creator,note,tag) values(?,?,?,?,?,?,?,?,?)";
		int r = 0;
		try {
			PreparedStatement ps =  (conn=dataSource.getConnection()).prepareStatement(sql);
			ps.setString(1, t.getC_id());
			ps.setString(2, t.getWord_id());
			ps.setString(3, t.getName());
			ps.setInt(4, t.getReferred());
			ps.setDate(5, t.getCreate_date());
			ps.setDate(6, t.getUpdate_date());
			ps.setString(7, t.getCreator());
			ps.setString(8, t.getNote());
			ps.setString(9, t.getTag());

			r = ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage() + " : " + this.getClass().getName() + "::add");
		}

		return r > 0 ? true : false;
	}

	@Override
	public Card queryByID(String id) {
		Connection conn = null;

		String sql = "select * from card where c_id=?";
		Card r = null;
		try {
			PreparedStatement ps =  (conn=dataSource.getConnection()).prepareStatement(sql);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				r = new Card();
				r.setC_id(rs.getString("c_id"));
				r.setWord_id(rs.getString("word_id"));
				r.setName(rs.getString("name"));
				r.setReferred(rs.getInt("referred"));
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
	public List<Card> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String id, Card t) {
		Connection conn = null;

		String sql = "update card set c_id=?,word_id=?,name=?,referred=?,create_date=?,update_date=?,"
				+ "creator=?,note=?,tag=? where c_id=?";
		int r = 0;
		try {
			PreparedStatement ps =  (conn=dataSource.getConnection()).prepareStatement(sql);
			ps.setString(1, t.getC_id());
			ps.setString(2, t.getWord_id());
			ps.setString(3, t.getName());
			ps.setInt(4, t.getReferred());
			ps.setDate(5, t.getCreate_date());
			ps.setDate(6, t.getUpdate_date());
			ps.setString(7, t.getCreator());
			ps.setString(8, t.getNote());
			ps.setString(9, t.getTag());
			ps.setString(10, id);

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

	@Override
	public Card find(String sqlSegment, String... querys) throws ResultNullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Test
	public void test() {
		// testAdd();
		testUpdate();
	}

	// @Test
	public void testAdd() {
		Card c = new Card();
		c.setC_id("c125");
		c.setName("cc125");
		c.setWord_id("e137");
		c.setReferred(0);
		c.setCreate_date(new Date(new java.util.Date().getTime()));
		c.setCreator("u123");

		CardDao dao = new CardDao();
		dao.add(c);
	}

	// @Test
	public void testUpdate() {
		CardDao dao = new CardDao();
		Card c = dao.queryByID("c125");
		String id = c.getC_id();
		c.setWord_id("e139");

		dao.update(id, c);
	}

}
