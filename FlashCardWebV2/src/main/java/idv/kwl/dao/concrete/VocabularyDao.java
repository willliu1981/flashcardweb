package idv.kwl.dao.concrete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import idv.kwl.dao.AbsVocabularyDao;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vocabulary> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
