package idv.fc.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

import idv.fc.dao.abs.CommonDao;
import idv.fc.model.Vocabulary;

public class VocabularyCommonDao extends CommonDao<Vocabulary> {

	private VocabularyCommonDao() {
		super(Vocabulary.class);
	}

	@Override
	protected void createModelForQuery(ResultSet rs, Vocabulary model)
			throws SQLException {
		model.setId(rs.getString("id"));
		model.setVocabulary(rs.getString("vocabulary"));
		model.setTranslation(rs.getString("translation"));
		model.setCreate_date(rs.getDate("create_date"));
		model.setTag(rs.getString("tag"));

	}

	@Override
	protected void createMapForCreate(Map<String, Object> cols, Vocabulary model) {
		cols.put("id", model.getId());
		cols.put("vocabulary", model.getVocabulary());
		cols.put("translation", model.getTranslation());
		cols.put("create_date", Date.valueOf(LocalDate.now()));

	}

	@Override
	protected void createMapForUpdate(Map<String, Object> cols, Vocabulary model) {
		cols.put("id", model.getId());
		cols.put("vocabulary", model.getVocabulary());
		cols.put("translation", model.getTranslation());

	}

}
