package com.ilan.control.factory.daofactory;

import org.springframework.context.ApplicationContext;

import com.ilan.control.config.Config;
import com.ilan.control.factory.IFactory;

public interface IDaoFactory extends IFactory {
	public IDao<?> getDao(String id, Class<? extends IDao> clazz);
	

}
