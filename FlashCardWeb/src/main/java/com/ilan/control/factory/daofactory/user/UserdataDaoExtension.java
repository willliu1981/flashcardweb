package com.ilan.control.factory.daofactory.user;

import java.sql.SQLException;

import com.ilan.exception.ResultNullException;

public interface UserdataDaoExtension<T> {
	T findByEmail(String email) throws ResultNullException, SQLException;
}
