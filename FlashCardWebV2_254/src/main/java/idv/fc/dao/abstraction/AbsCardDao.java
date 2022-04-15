package idv.fc.dao.abstraction;

import java.sql.ResultSet;
import java.sql.SQLException;

import idv.fc.model.Card;

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
		model.setCreate_date(rs.getDate("create_date"));
		model.setLast_time(rs.getTimestamp("create_date"));
		model.setUsage_count(rs.getInt("usage_count"));
		model.setTag(rs.getString("tag"));
		model.setExam_count(rs.getInt("exam_count"));
		model.setPass_count(rs.getInt("pass_count"));
		model.setStep(rs.getInt("step"));
		model.setStep_time(rs.getTimestamp("step_time"));
		model.setUid(rs.getString("uid"));

		return model;
	}

}
