package idv.kwl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbsVocabularyDao<T> extends AbsDao implements IDao<T> {

	@Override
	public void delete(Object id) {
		String sql = "delete from  vocabulary where vid=?";

		Connection conn = this.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setObject(1, id);
			st.execute();

			this.closeResources(st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
