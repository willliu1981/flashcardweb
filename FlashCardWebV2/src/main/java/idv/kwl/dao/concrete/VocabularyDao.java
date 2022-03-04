package idv.kwl.dao.concrete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import idv.kwl.dao.AbsVocabularyDao;
import idv.kwl.model.Card;
import idv.kwl.model.Vocabulary;

public class VocabularyDao extends AbsVocabularyDao<Vocabulary> {

	@Override
	public void create(Vocabulary t) {
		String sql = "insert into vocabulary (vid,vocabulary,translation,create_date)"
				+ " values (?,?,?,?)";

		Connection conn = this.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, t.getVid().trim());
			st.setString(2, t.getVocabulary().trim());
			st.setString(3, t.getTranslation());
			st.setDate(4, t.getCreate_date());

			st.execute();

			this.closeResources(st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Vocabulary t, Object id) {
		String sql = "update vocabulary set vid=?,vocabulary=?,translation=?"
				+ ",tag=? where vid=?";

		Connection conn = this.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, t.getVid().trim());
			st.setString(2, t.getVocabulary().trim());
			st.setString(3, t.getTranslation());
			st.setString(4, t.getTag());
			st.setString(5, id.toString());

			st.execute();

			this.closeResources(st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Vocabulary queryById(Object id) {
		String sql = "select * from vocabulary where vid=?";

		Connection conn = this.getConnection();
		Vocabulary model = null;
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, id.toString());
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				model = new Vocabulary();
				model.setVid(rs.getString("vid"));
				model.setVocabulary(rs.getString("vocabulary"));
				model.setTranslation(rs.getString("translation"));
				model.setCreate_date(rs.getDate("create_date"));
				model.setTag(rs.getString("tag"));
			}
			this.closeResources(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return model;
	}

	@Override
	public List<Vocabulary> queryAll() {
		String sql = "select * from vocabulary ";

		Connection conn = this.getConnection();
		List<Vocabulary> list = new ArrayList<>();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			Vocabulary model = null;
			while (rs.next()) {
				model = new Vocabulary();
				model.setVid(rs.getString("vid"));
				model.setVocabulary(rs.getString("vocabulary"));
				model.setTranslation(rs.getString("translation"));
				model.setCreate_date(rs.getDate("create_date"));
				model.setTag(rs.getString("tag"));
				list.add(model);
			}

			this.closeResources(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	protected Card createModel(ResultSet rs) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
