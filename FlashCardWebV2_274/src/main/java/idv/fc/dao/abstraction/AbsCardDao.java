package idv.fc.dao.abstraction;

import java.sql.ResultSet;
import java.sql.SQLException;

import idv.fc.pojo.Card;

public abstract class AbsCardDao extends OldBaseDao
		implements Dao<Card>, ProcessData<Card> {
	@Override
	public void delete(Object id) {
		String sql = "delete from  card where id=?";

		this.delete(id, sql);
	}

	@Override
	public Card createModel(ResultSet rs) throws SQLException {
		Card model = new Card();
		model.setId(rs.getInt("id"));
		model.setName(rs.getString("name"));
		model.setVid(rs.getString("vid"));
		model.setCreateDate(rs.getDate("create_date"));
		model.setLastTime(rs.getTimestamp("create_date"));
		model.setUsageCount(rs.getInt("usage_count"));
		model.setTag(rs.getString("tag"));
		model.setExamCount(rs.getInt("exam_count"));
		model.setPassCount(rs.getInt("pass_count"));
		model.setStep(rs.getInt("step"));
		model.setStepTime(rs.getTimestamp("step_time"));
		model.setUid(rs.getString("uid"));

		return model;
	}

}
