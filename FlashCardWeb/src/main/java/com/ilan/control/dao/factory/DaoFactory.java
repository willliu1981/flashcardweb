package com.ilan.control.dao.factory;

public class DaoFactory {
	

	private DaoFactory() {
	}

	public static UserDaoFactory getUserDaoFactory() {
		return UserDaoFactory.getInstance();
	}




}
