package com.ilan.control.factory.daofactory.user;


import java.sql.SQLException;

import com.ilan.control.factory.daofactory.IDao;
import com.ilan.exception.ResultNullException;

public interface IUserDao<T> extends IDao<T> {
	T identifyUser(String username, String password) throws ResultNullException, SQLException;
	T findByUsername(String username) throws ResultNullException, SQLException;
	void setDefaultAuthority();
}
