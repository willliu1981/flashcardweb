package com.flashcard.dao.user;

import java.sql.SQLException;
import java.util.List;

import com.flashcard.dao.IDao;
import com.flashcard.exception.ResultNullException;

public interface IUserDao<T> extends IDao<T> {
	T identifyUser(String username, String password)
			throws ResultNullException, SQLException;

	T findByUsername(String username) throws ResultNullException, SQLException;

	default List<T> findsLimit( Integer page, Integer maxPage)
			throws ResultNullException, SQLException {

		return null;
	}

	default List<T> findsOrderLimit( String order,
			Integer page, Integer maxPage)
			throws ResultNullException, SQLException {

		return null;
	}
}
