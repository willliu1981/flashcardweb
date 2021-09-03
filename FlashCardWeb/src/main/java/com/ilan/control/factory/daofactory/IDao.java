package com.ilan.control.factory.daofactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.ilan.exception.ResultNullException;

public interface IDao<T> {

	public void setDataSource(DataSource dataSource);

	public boolean add(T t);

	public T queryByID(String idSegment) throws IOException, SQLException;

	public List<T> queryAll();

	public int update(String id, T t);

	public int delete(String id);

	T find(String sqlSegment, String... querys) throws ResultNullException, SQLException;
}
