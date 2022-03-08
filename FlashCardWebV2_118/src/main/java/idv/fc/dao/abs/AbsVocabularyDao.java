package idv.fc.dao.abs;

public abstract class AbsVocabularyDao<T> extends AbsDao implements IDao<T> {

	@Override
	public void delete(Object id) {
		String sql = "delete from  vocabulary where vid=?";

		this.delete(id, sql);
	}

}
