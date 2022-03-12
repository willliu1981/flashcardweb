package idv.fc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import idv.fc.dao.abstraction.Dao;
import idv.fc.model.User;

public abstract class Faker {

	private Faker realFaker;

	@Autowired
	@Qualifier("EmptyUser")
	private User user;

	@Autowired
	@Qualifier("UserCommonDao")
	private Dao<User> dao;

	public User getUser() {
		return this.getRealFaker().user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Dao<User> getDao() {
		return this.getRealFaker().dao;
	}

	public void setDao(Dao<User> dao) {
		this.dao = dao;
	}

	protected void createFaker(Faker innerFaker) {
		this.realFaker = innerFaker;
	}

	protected Faker getRealFaker() {
		return realFaker;
	}

}
