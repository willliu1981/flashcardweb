package idv.fc.controller.abstraction;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import idv.fc.dao.abstraction.Dao;
import idv.fc.model.User;

public abstract class BaseController {
	private static Dao<User> staticUserCommonDao;

	@Autowired
	@Qualifier("UserCommonDao")
	private Dao<User> userCommonDao;

	protected Dao<User> getUserCommonDao() {
		return staticUserCommonDao;
	}

	@PostConstruct
	private void initStaticDao() {
		staticUserCommonDao = this.userCommonDao;
	}

}
