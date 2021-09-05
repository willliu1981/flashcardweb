package com.ilan.appinitialization;

import java.util.HashMap;
import java.util.Map;

import com.ilan.control.factory.IFactory;
import com.ilan.control.factory.daofactory.user.IUserDao;

public abstract class InitFactory {
	private final static String [] xmls;
	static{
		//init
		xmls= new String[]{""};
	}
	private final static Class<IFactory> rootFactoryType = IFactory.class;
	private final static Map<String, Class> configTypeMap = new HashMap<>();
	public final static ConfigClassTypeReference<IFactory> DAOFACTORY = new ConfigClassTypeReference(
			"daoFactory", rootFactoryType);
	public final static ConfigClassTypeReference<IUserDao> USERDAO = new ConfigClassTypeReference("userDao",
			IUserDao.class);
	
	public abstract <T> T getFactory(ConfigClassTypeReference<T> type) ;

	
	
}
