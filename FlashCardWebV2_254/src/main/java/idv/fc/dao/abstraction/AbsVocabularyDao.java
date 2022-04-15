package idv.fc.dao.abstraction;

import java.sql.ResultSet;
import java.sql.SQLException;

import idv.fc.pojo.Vocabulary;

public abstract class AbsVocabularyDao extends OldBaseDao
		implements Dao<Vocabulary>, ProcessData<Vocabulary> {

	@Override
	public void delete(Object id) {
		String sql = "delete from  vocabulary where id=?";

		this.delete(id, sql);
	}

	@Override
	public Vocabulary createModel(ResultSet rs) throws SQLException {
		Vocabulary model = new Vocabulary();
		model.setId(rs.getString("id"));
		model.setVocabulary(rs.getString("vocabulary"));
		model.setTranslation(rs.getString("translation"));
		model.setCreate_date(rs.getDate("create_date"));
		model.setTag(rs.getString("tag"));

		return model;
	}

}
