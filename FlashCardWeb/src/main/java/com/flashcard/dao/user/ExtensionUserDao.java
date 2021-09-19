package com.flashcard.dao.user;

import java.sql.SQLException;
import java.util.List;

import com.flashcard.exception.ResultNullException;
import com.flashcard.model.user.User;

public class ExtensionUserDao extends UserDao {

	@Override
	public List<User> findsLimit(Integer page, Integer maxPage)
			throws ResultNullException, SQLException {
		String sqlSegment = String.format("select * from user limit %d,%d",
				(page - 1) * maxPage, maxPage);
		
		return this.finds(sqlSegment);
	}

}
