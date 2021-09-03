package com.ilan.control.factory.deprecated;

import com.ilan.control.factory.daofactory.IDao;

public abstract class AbstractDaoFactory {
	public abstract void setDaoType(String clazz) ;
	public abstract IDao<?> getDefaultDao();
}
