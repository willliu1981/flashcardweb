package com.ilan.control.dao.factory;

public interface UserDaoExtension<T> {
	T identifyUser(String username, String password);
}
