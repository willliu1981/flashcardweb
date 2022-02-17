package idv.kwl.handle.dao.concrete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import idv.kwl.handle.connection.Connection;
import idv.kwl.handle.dao.Dao;
import idv.kwl.model.Vocabulary;

public class VocabularyDao extends Dao<Vocabulary> {

	@Override
	public void create(Vocabulary t) {
		String sql = "insert into vocabulary (vid,vocabulary,translation,create_date) values (?,?,?,?)";

		try {
			PreparedStatement ps = Connection.getMysqlConnection()
					.prepareStatement(sql);
			ps.setString(1, t.getVid());
			ps.setString(2, t.getVocabulary());
			ps.setString(3, t.getTranslation());
			ps.setDate(4, t.getCreate_date());

			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Vocabulary t, Object id) {
		// TODO Auto-generated method stub

	}

}
