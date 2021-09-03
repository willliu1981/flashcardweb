package com.ilan.control.factory.daofactory;

import javax.sql.DataSource;

public abstract class AbstractDao<T> implements IDao<T> {
	protected DataSource dataSoucrce;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSoucrce = dataSource;

	}

}
