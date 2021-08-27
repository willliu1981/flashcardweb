package com.ilan.control.dao.factory;

import com.ilan.control.dao.factory.user.UserDaoFactory;

public class DaoFactory {
	

	private DaoFactory() {
	}

	public static UserDaoFactory getUserDaoFactory() {
		return UserDaoFactory.getInstance();
	}




}
