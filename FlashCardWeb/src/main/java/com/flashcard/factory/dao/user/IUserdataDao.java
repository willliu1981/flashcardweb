package com.flashcard.factory.dao.user;


import java.sql.SQLException;

import com.flashcard.exception.ResultNullException;
import com.flashcard.factory.dao.IDao;

public interface IUserdataDao<T> extends IDao<T> {
	T findByEmail(String email) throws ResultNullException, SQLException;
}
