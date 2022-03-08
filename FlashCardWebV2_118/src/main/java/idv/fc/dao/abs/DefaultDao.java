package idv.fc.dao.abs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public abstract class DefaultDao<T> extends BaseDao<T> {

	@Override
	protected void createMapForCreate(T model, Map<String, Object> cols) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createMapForUpdate(T model, Map<String, Object> cols) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected T createModelForQuery(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
