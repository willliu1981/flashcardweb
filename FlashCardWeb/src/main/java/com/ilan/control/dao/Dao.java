package com.ilan.control.dao;

import java.io.IOException;
import java.util.List;

import com.ilan.exception.ResultNullException;

public interface Dao<T> {

	public boolean add(T t);

	public default T queryByID(String idSegment) throws IOException {
		throw new ResultNullException();
	}

	public List<T> queryAll();

	public int update(String id, T t);

	public int delete(String id);

	default T findByDefault(String sqlSegment, String... querys) throws ResultNullException {
		throw new ResultNullException();
	}
}
