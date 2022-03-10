package idv.fc.dao.abstraction;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ProcessData<T> {
	T createModel(ResultSet rs) throws SQLException;
}
