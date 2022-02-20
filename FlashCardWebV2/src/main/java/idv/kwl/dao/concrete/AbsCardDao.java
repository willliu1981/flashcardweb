package idv.kwl.dao.concrete;

import idv.kwl.dao.AbsDao;
import idv.kwl.dao.IDao;
import idv.kwl.model.Card;

public abstract class AbsCardDao extends AbsDao implements IDao<Card> {
	@Override
	public void delete(Object id) {
		String sql = "delete from  card where cid=?";

		this.delete(id, sql);
	}
}
