package com.ilan.control.factory.daofactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ilan.control.config.Config;
import com.ilan.control.dao.user.UserDao;
import com.ilan.control.factory.deprecated.UserDaoFactory;

public final class DaoFactory implements IDaoFactory {
	private static ApplicationContext factory = null;

	private DaoFactory() {
	}

	public static UserDaoFactory getUserDaoFactory() {
		return UserDaoFactory.getInstance();
	}

	@Override
	public IDao<?> getDao(String id, Class<? extends IDao> clazz) {

		return factory.getBean(id, clazz);
	}

	@Override
	public void init() {
		factory = new ClassPathXmlApplicationContext(config.getDaoFactory());
	}

}
