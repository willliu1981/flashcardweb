package com.flashcard.dao.user;


import java.sql.SQLException;

import com.flashcard.dao.IDao;
import com.flashcard.exception.ResultNullException;

public interface IUserdataDao<T> extends IDao<T> {
	T findByEmail(String email) throws ResultNullException, SQLException;
}
