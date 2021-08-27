package com.ilan.control.dao.factory.user;

public interface UserDaoExtension<T> {
	T identifyUser(String username, String password);
}
