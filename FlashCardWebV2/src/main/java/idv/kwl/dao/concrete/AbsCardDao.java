package idv.kwl.dao.concrete;

import java.sql.ResultSet;
import java.sql.SQLException;

import idv.kwl.dao.AbsDao;
import idv.kwl.dao.IDao;
import idv.kwl.model.Card;
import idv.kwl.model.proxy.ICard;

public abstract class AbsCardDao extends AbsDao implements IDao<Card> {
	@Override
	public void delete(Object id) {
		String sql = "delete from  card where cid=?";

		this.delete(id, sql);
	}

	protected Card createModel(ResultSet rs) throws SQLException {
		Card model = new Card();
		model.setCid(rs.getInt("cid"));
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
