package com.ilan.control.factory.daofactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ilan.control.factory.daofactory.user.IUserDao;
import com.ilan.control.factory.deprecated.UserDaoFactory;

public final class DaoFactory implements IDaoFactory {
	private static ApplicationContext factory = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	private DaoFactory() {
	}

	public static UserDaoFactory getUserDaoFactory() {
		return UserDaoFactory.getInstance();
	}

	public static IUserDao getUserDao() {
		return factory.getBean("userDao", IUserDao.class);
	}

	@Override
	public IDao getDao(String id, Class<? extends IDao> clazz) {

		return factory.getBean(id, clazz);
	}

}
