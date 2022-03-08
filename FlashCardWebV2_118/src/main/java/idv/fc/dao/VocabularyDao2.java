package idv.fc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import idv.fc.dao.abs.BaseDao2;
import idv.fc.model.Vocabulary;

public class VocabularyDao2 extends BaseDao2<Vocabulary> {

	private VocabularyDao2() {
	}

	@Override
	public void create(Vocabulary t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Vocabulary t, Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vocabulary createModelForQuery(ResultSet rs) throws SQLException {
		Vocabulary model = new Vocabulary();
		model.setId(rs.getString("id"));
		model.setVocabulary(rs.getString("vocabulary"));
		model.setTranslation(rs.getString("translation"));
		model.setCreate_date(rs.getDate("create_date"));
		model.setTag(rs.getString("tag"));

		return model;
	}

}
