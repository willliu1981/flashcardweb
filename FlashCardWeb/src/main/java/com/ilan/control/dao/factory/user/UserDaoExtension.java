package com.ilan.control.dao.factory.user;

import com.ilan.exception.ResultNullException;

public interface UserDaoExtension<T> {
	T identifyUser(String username, String password) throws ResultNullException;
	T findByUsername(String username) throws ResultNullException;
}
