package com.ilan.control.dao.factory;

import com.ilan.control.dao.Dao;
import com.ilan.control.dao.user.UserDao;
import com.ilan.model.user.User;

public class UserDaoFactory {
	private static UserDaoFactory factory = new UserDaoFactory();
	private Class<UserDao> clazz = UserDao.class;

	private UserDaoFactory() {
	}

	public static UserDaoFactory getInstance() {
		return factory;
	}

	public Dao<?> getUserDao() {
		try {
			return clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean identifyUser(String username, String password) {
		User user;
		try {
			user = clazz.newInstance().identifyUser(username, password);
			if (user != null) {
				return true;
			} else {
				return false;
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return false;
	}
}
