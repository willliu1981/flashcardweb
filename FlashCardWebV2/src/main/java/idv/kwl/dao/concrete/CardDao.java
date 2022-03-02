package idv.kwl.dao.concrete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import idv.kwl.model.Card;
import idv.kwl.model.Vocabulary;

public class CardDao extends AbsCardDao {

	@Override
	public void create(Card t) {
		String sql = "insert into card (name,vid,create_date)" + " values (?,?,?)";

		Connection conn = this.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, t.getName().trim());
			st.setString(2, t.getVid().trim());
			st.setDate(3, t.getCreate_date());

			st.execute();

			this.closeResources(st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Card t, Object id) {
		String sql = "update card set name=?,vid=?,last_time=?,usage_count=?,"
				+ "tag=?,exam_count=?,pass_count=? where cid=?";

		Connection conn = this.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, t.getName().trim());
			st.setString(2, t.getVid());
			st.setTimestamp(3, t.getLast_time());
			st.setInt(4, t.getUsage_count());
			st.setString(5, t.getTag());
			st.setInt(6, t.getExam_count());
			st.setInt(7, t.getPass_count());
			st.setInt(8, Integer.parseInt(id.toString()));

			st.execute();

			this.closeResources(st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Card queryById(Object id) {
		String sql = "select * from card where cid=?";

		Connection conn = this.getConnection();
		Card model = null;
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, Integer.valueOf(id.toString()));
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				model = new Card();
				model.setCid(rs.getInt("cid"));
				model.setName(rs.getString("name"));
				model.setVid(rs.getString("vid"));
				model.setCreate_date(rs.getDate("create_date"));
				model.setLast_time(rs.getTimestamp("create_date"));
				model.setUsage_count(rs.getInt("usage_count"));
				model.setTag(rs.getString("tag"));
				model.setExam_count(rs.getInt("exam_count"));
				model.setPass_count(rs.getInt("pass_count"));
			}

			this.closeResources(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return model;
	}

	@Override
	public List<Card> queryAll() {
		String sql = "select * from card ";

		Connection conn = this.getConnection();
		List<Card> list = new ArrayList<>();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			Card model = null;
			while (rs.next()) {
				model = new Card();
				model.setCid(rs.getInt("cid"));
				model.setName(rs.getString("name"));
				model.setVid(rs.getString("vid"));
				model.setCreate_date(rs.getDate("create_date"));
				model.setLast_time(rs.getTimestamp("create_date"));
				model.setUsage_count(rs.getInt("usage_count"));
				model.setTag(rs.getString("tag"));
				model.setExam_count(rs.getInt("exam_count"));
				model.setPass_count(rs.getInt("pass_count"));
				list.add(model);
			}

			this.closeResources(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
