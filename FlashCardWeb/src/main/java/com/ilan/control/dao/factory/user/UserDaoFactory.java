package com.ilan.control.dao.factory.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ilan.control.connection.MyConnection;
import com.ilan.control.dao.Dao;
import com.ilan.control.dao.factory.AbstractDaoFactory;
import com.ilan.exception.ResultNullException;
import com.ilan.model.user.User;

public class UserDaoFactory extends AbstractDaoFactory {
	private static UserDaoFactory factory;
	private Class<?> clazz;

	public UserDaoFactory() {
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
			try {
				factory = (UserDaoFactory) new InitialContext()
						.lookup("java:comp/env/daoFactory/UserDaoFactory");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return factory;
	}

	@Override
	public Dao<?> getDefaultDao() {
		try {
			return (Dao<?>) clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean identifyUser(String username, String password) {
		User user;
		try {
			user = (User) ((UserDaoExtension<?>) clazz.newInstance()).identifyUser(username,
					password);
			if (user != null) {
				return true;
			} else {
				return false;
			}
		} catch (InstantiationException | IllegalAccessException | ResultNullException e) {
			System.out.println(this.getClass().getName() + "::identifyUser:" + e.getMessage());
		}
		return false;
	}

	public User findUserByUsername(String username) {
		User user = null;
		try {
			user = (User) ((UserDaoExtension<?>) clazz.newInstance()).findByUsername(username);
		} catch (InstantiationException | IllegalAccessException | ResultNullException e) {
			System.out.println(this.getClass().getName() + "::findUserByUsername:" + e.getMessage());
		}
		return user;
	}

}
