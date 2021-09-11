package com.flashcard.factory.dao.user;


import java.sql.SQLException;

import com.flashcard.exception.ResultNullException;
import com.flashcard.factory.dao.IDao;

public interface IUserDao<T> extends IDao<T> {
	T identifyUser(String username, String password) throws ResultNullException, SQLException;
	T findByUsername(String username) throws ResultNullException, SQLException;
	void setDefaultAuthority();
}
