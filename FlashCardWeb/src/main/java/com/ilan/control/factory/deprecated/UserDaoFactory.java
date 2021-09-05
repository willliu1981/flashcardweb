package com.ilan.control.factory.deprecated;

import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ilan.appinitialization.Config;
import com.ilan.control.factory.daofactory.IDao;
import com.ilan.control.factory.daofactory.user.UserDaoExtension;
import com.ilan.exception.ResultNullException;
import com.ilan.model.user.User;

public class UserDaoFactory extends AbstractDaoFactory {

	private static UserDaoFactory factory;
	private Class<?> clazz;
	ApplicationContext appFactory = new ClassPathXmlApplicationContext(
			Config.config.getConnectionXml());

	private DataSource dataSource;

	public UserDaoFactory() {
		dataSource = appFactory.getBean("dataSource", DataSource.class);
	}

	@Override
	public void setDaoType(String klazz) {
		if (clazz == null) {
			try {
				clazz = Class.forName(klazz);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public static UserDaoFactory getInstance() {
		if (factory == null) {
			// *
			try {
				factory = (UserDaoFactory) new InitialContext()
						.lookup("java:comp/env/daoFactory/UserDaoFactory");
			} catch (NamingException e) {
				e.printStackTrace();
			}
			// */

		}
		return factory;
	}

	@Override
	public IDao<?> getDefaultDao() {
		try {
			IDao<?> dao = (IDao<?>) clazz.newInstance();
			dao.setDataSource(dataSource);
			return dao;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean identifyUser(String username, String password) {
		User user;
		try {
			clazz.newInstance();
			IDao<?> dao = (IDao<?>) clazz.newInstance();
			dao.setDataSource(dataSource);
			user = (User) ((UserDaoExtension<?>) dao).identifyUser(username, password);
			if (user != null) {
				return true;
			} else {
				return false;
			}
		} catch (InstantiationException | IllegalAccessException | ResultNullException
				| SQLException e) {
			System.out.println(this.getClass().getName() + "::identifyUser:" + e.getMessage());
		}
		return false;
	}

	public User findUserByUsername(String username) {
		User user = null;
		try {
			IDao<?> dao = (IDao<?>) clazz.newInstance();
			dao.setDataSource(dataSource);
			user = (User) ((UserDaoExtension<?>) dao).findByUsername(username);
		} catch (InstantiationException | IllegalAccessException | ResultNullException
				| SQLException e) {
			System.out
					.println(this.getClass().getName() + "::findUserByUsername:" + e.getMessage());
		}
		return user;
	}

}
