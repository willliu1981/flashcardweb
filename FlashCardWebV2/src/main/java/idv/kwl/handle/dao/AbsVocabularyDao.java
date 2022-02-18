package idv.kwl.handle.dao;

import java.sql.Connection;

import idv.kwl.component.SpringUtil;
import idv.kwl.connection.DataSource;

public abstract class AbsVocabularyDao<T> implements IDao<T> {

	private DataSource dataSource = (DataSource) SpringUtil.getBean("dataSource");

	protected Connection getConnection() {
		return this.dataSource.getConnection();
	}

}
