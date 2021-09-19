package com.flashcard.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.flashcard.exception.ResultNullException;

public interface IDao<T> {

	public void setDataSource(DataSource dataSource);

	public boolean add(T t) throws SQLException;

	public T queryByID(String idSegment) throws IOException, SQLException;

	public List<T> queryAll() throws SQLException, ResultNullException;

	public int update(String id, T t);

	public int delete(String id);

	T find(String sqlSegment, String... querys)
			throws ResultNullException, SQLException;

	default List<T> finds(String sqlSegment, String... querys)
			throws ResultNullException, SQLException {

		return null;
	}
	
	default int count() {
		return 0;
	}



}
