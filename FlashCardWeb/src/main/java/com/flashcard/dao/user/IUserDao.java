package com.flashcard.dao.user;


import java.sql.SQLException;

import com.flashcard.dao.IDao;
import com.flashcard.exception.ResultNullException;

public interface IUserDao<T> extends IDao<T> {
	T identifyUser(String username, String password) throws ResultNullException, SQLException;
	T findByUsername(String username) throws ResultNullException, SQLException;
	

}
