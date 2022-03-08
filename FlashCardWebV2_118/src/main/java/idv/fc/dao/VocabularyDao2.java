package idv.fc.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

import idv.fc.dao.abs.CommonDao;
import idv.fc.model.Vocabulary;

public class VocabularyDao2 extends CommonDao<Vocabulary> {

	private VocabularyDao2() {
	}

	@Override
	protected Vocabulary createModelForQuery(ResultSet rs) throws SQLException {
		Vocabulary model = new Vocabulary();
		model.setId(rs.getString("id"));
		model.setVocabulary(rs.getString("vocabulary"));
		model.setTranslation(rs.getString("translation"));
		model.setCreate_date(rs.getDate("create_date"));
		model.setTag(rs.getString("tag"));

		return model;
	}

	@Override
	protected void createMapForCreate(Vocabulary model, Map<String, Object> cols) {
		cols.put("id", model.getId());
		cols.put("vocabulary", model.getVocabulary());
		cols.put("translation", model.getTranslation());
		cols.put("create_date", Date.valueOf(LocalDate.now()));

	}

	@Override
	protected void createMapForUpdate(Vocabulary model, Map<String, Object> cols) {
		cols.put("id", model.getId());
		cols.put("vocabulary", model.getVocabulary());
		cols.put("translation", model.getTranslation());

	}

}
