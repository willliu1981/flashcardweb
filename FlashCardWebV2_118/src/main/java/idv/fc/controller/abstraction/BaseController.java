package idv.fc.controller.abstraction;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import idv.fc.dao.abstraction.Dao;
import idv.fc.model.User;

public abstract class BaseController {
	private static Dao<User> staticUserDao;

	@Autowired
	@Qualifier("UserDao")
	private Dao<User> userDao;

	protected Dao<User> getUserDao() {
		return staticUserDao;
	}

	@PostConstruct
	private void initStaticDao() {
		staticUserDao = this.userDao;
	}

}
