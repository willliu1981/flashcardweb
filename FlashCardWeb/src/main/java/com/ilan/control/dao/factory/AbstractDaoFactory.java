package com.ilan.control.dao.factory;

import com.ilan.control.dao.Dao;

public abstract class AbstractDaoFactory {
	protected abstract void setDaoType(String clazz) ;
	public abstract Dao<?> getDefaultDao();
}
