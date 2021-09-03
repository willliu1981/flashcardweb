package com.ilan.control.factory.daofactory;

import com.ilan.control.factory.IFactory;

public interface IDaoFactory extends IFactory{
	public IDao getDao(String id,Class<? extends IDao> clazz);
}
