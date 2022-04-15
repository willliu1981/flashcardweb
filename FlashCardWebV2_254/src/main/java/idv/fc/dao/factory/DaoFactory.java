package idv.fc.dao.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import idv.fc.dao.abstraction.Dao;
import idv.fc.model.User;

public class DaoFactory {

	private static Dao<User> userDao;

	public static Dao<User> getUserDao() {
		
	
		return userDao;
	}

	@Autowired
	@Qualifier("UserDao")
	public void setUserDao(Dao<User> userDao) {
		DaoFactory.userDao = userDao;
	}

}
