package com.ilan.control.factory.daofactory.user;

import java.sql.SQLException;

import com.ilan.exception.ResultNullException;

public interface UserDaoExtension<T> {
	T identifyUser(String username, String password) throws ResultNullException, SQLException;
	T findByUsername(String username) throws ResultNullException, SQLException;
	void setDefaultAuthority();
}
