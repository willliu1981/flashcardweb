package com.ilan.control.factory.daofactory;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<T> implements IDao<T> {

	protected DataSource dataSourcex;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSourcex = dataSource;
	}

	@Override
	public DataSource getDataSource() throws SQLException {
		if(dataSourcex==null) {
			throw new SQLException("DataSource is null");
		}
		return dataSourcex;
	}


	
	

}
