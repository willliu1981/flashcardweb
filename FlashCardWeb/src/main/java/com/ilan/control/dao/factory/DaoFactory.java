package com.ilan.control.dao.factory;

import com.ilan.control.dao.user.UserDao;

public class DaoFactory {

	private DaoFactory() {
	}

	public static UserDaoFactory getUserDaoFactory() {
		return UserDaoFactory.getInstance();
	}


}
