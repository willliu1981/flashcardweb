package com.ilan.control.factory.daofactory;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ilan.control.config.Config;
import com.ilan.control.dao.user.UserDao;
import com.ilan.control.factory.deprecated.UserDaoFactory;

public final class DaoFactory implements IDaoFactory {
	private static ApplicationContext factory = null;
	private static DataSource dataSource;

	private DaoFactory() {
	}

	public static UserDaoFactory getUserDaoFactory() {
		return UserDaoFactory.getInstance();
	}

	@Override
	public IDao<?> getDao(String id, Class<? extends IDao> clazz) {
		IDao<?> dao = getApplicationContext().getBean(id, clazz);
		dao.setDataSource(dataSource);
		return dao;
	}

	@Override
	public ApplicationContext getApplicationContext() {
		if (factory == null) {
			factory = new ClassPathXmlApplicationContext(Config.config.getDaoFactoryXml());
		}

		return factory;
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		DaoFactory.dataSource = dataSource;

	}

}
