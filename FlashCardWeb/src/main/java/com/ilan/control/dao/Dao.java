package com.ilan.control.dao;

import java.util.List;

public interface Dao<T> {
	
	public boolean add(T t);
	public T queryByID(String id);
	public T queryByVocabulary(String vocabulary);
	public List<T> queryAll();
	public int update(String id,T t);
	public int delete(String id);
}
