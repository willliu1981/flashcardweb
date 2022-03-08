package idv.fc.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

import idv.fc.dao.abs.BaseDao2;
import idv.fc.model.Vocabulary;

public class VocabularyDao2 extends BaseDao2<Vocabulary> {

	private VocabularyDao2() {
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

	@Override
	public void createMapForCreate(Vocabulary model, Map<String, Object> cols) {
		cols.put("id", model.getId());
		cols.put("vocabulary", model.getVocabulary());
		cols.put("translation", model.getTranslation());
		cols.put("create_date", Date.valueOf(LocalDate.now()));

	}

	@Override
	public void createMapForUpdate(Vocabulary model, Map<String, Object> cols) {
		cols.put("id", model.getId());
		cols.put("vocabulary", model.getVocabulary());
		cols.put("translation", model.getTranslation());

	}

}
