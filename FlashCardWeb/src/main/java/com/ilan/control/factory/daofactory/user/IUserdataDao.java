package com.ilan.control.factory.daofactory.user;


import java.sql.SQLException;

import com.ilan.control.factory.daofactory.IDao;
import com.ilan.exception.ResultNullException;

public interface IUserdataDao<T> extends IDao<T> {
	T findByEmail(String email) throws ResultNullException, SQLException;
}
