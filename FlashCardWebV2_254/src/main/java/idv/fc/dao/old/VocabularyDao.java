package idv.fc.dao.old;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import idv.fc.dao.abstraction.AbsVocabularyDao;
import idv.fc.pojo.Vocabulary;

public class VocabularyDao extends AbsVocabularyDao {

	@Override
	public void create(Vocabulary t) {
		String sql = "insert into vocabulary (id,vocabulary,translation,create_date)"
				+ " values (?,?,?,?)";

		Connection conn = this.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, t.getId().trim());
			st.setString(2, t.getVocabulary().trim());
			st.setString(3, t.getTranslation());
			st.setDate(4, t.getCreateDate());

			st.execute();

			this.closeResources(st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Vocabulary t, Object id) {
		String sql = "update vocabulary set id=?,vocabulary=?,translation=?"
				+ ",tag=? where id=?";

		Connection conn = this.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, t.getId().trim());
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
		String sql = "select * from vocabulary where id=?";

		Connection conn = this.getConnection();
		Vocabulary model = null;
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, id.toString());
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
	public List<Vocabulary> querySQL(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vocabulary> querySQL(String sql, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}



}
