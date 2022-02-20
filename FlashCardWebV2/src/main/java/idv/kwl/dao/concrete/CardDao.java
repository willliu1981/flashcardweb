package idv.kwl.dao.concrete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import idv.kwl.model.Card;

public class CardDao extends AbsCardDao {

	@Override
	public void create(Card t) {
		String sql = "insert into card (name,vid,create_date)" + " values (?,?,?)";

		Connection conn = this.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, t.getName().trim());
			st.setString(2, t.getVid().trim());
			st.setDate(3, t.getCreate_date());

			st.execute();

			this.closeResources(st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Card t, Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Card queryById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Card> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
