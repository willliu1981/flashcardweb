package idv.fc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import idv.fc.dao.abstraction.AbsCardDao;
import idv.fc.model.Card;

public class CardDao extends AbsCardDao {

	@Override
	public void create(Card t) {
		String sql = "insert into card (name,vid,uid,create_date)"
				+ " values (?,?,?,?)";

		Connection conn = this.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, t.getName().trim());
			st.setString(2, t.getVid().trim());
			st.setString(3, t.getUid().trim());
			st.setDate(4, t.getCreate_date());

			st.execute();

			this.closeResources(st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Card t, Object id) {
		String sql = "update card set name=?,vid=?,last_time=?,usage_count=?,"
				+ "tag=?,exam_count=?,pass_count=?,step=?,step_time=?,uid=? where id=?";

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
			st.setInt(8, t.getStep());
			st.setTimestamp(9, t.getStep_time());
			st.setString(10, t.getUid());
			st.setInt(11, Integer.parseInt(id.toString()));

			st.execute();

			this.closeResources(st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Card queryById(Object id) {
		String sql = "select * from card where id=?";

		Connection conn = this.getConnection();
		Card model = null;
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, Integer.valueOf(id.toString()));
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				model = this.createModel(rs);
			}

			this.closeResources(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return model;
	}

	public List<Card> queryByUserId(Object id) {
		String sql = "select * from card where uid=? ";

		Connection conn = this.getConnection();
		List<Card> list = new ArrayList<>();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, id.toString());

			ResultSet rs = st.executeQuery();
			Card model = null;
			while (rs.next()) {
				model = this.createModel(rs);
				list.add(model);
			}

			this.closeResources(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
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
				model = this.createModel(rs);
				list.add(model);
			}

			this.closeResources(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int executeSQL(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Card> querySQL(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Card> querySQL(String sql, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}



}
