package idv.fc.proxy.concretion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idv.fc.dao.abstraction.Dao;
import idv.fc.exception.FindErrorException;
import idv.fc.model.User;
import idv.fc.proxy.ProxyFactory;
import idv.fc.proxy.interceptor.Shuttle;
import idv.tool.Debug;
import idv.tool.spring.SpringUtil;

public class UserFaker {

	private User primeUser;
	private User finalUser = null;
	private Shuttle shuttle = new Shuttle();

	Dao<User> dao;

	private Map<String, String> sessionValues = new HashMap<>();

	public UserFaker() {
		init();
	}

	private void init() {
		User user = new User();
		dao = (Dao<User>) SpringUtil.getBean("UserDao");

		try {
			this.primeUser = ProxyFactory.getProxyInstance("PreparedUserProxyFactory",
					user, this.shuttle);

		} catch (FindErrorException e) {
			e.printStackTrace();
		}

	}

	public String getToken() {
		return (String) this.shuttle.get("token");
	}

	public UserFaker setToken(String token) {
		// Debug.test(UserFaker.class, "set Token ", token);
		this.shuttle.put("token", token);
		return this;
	}

	protected void processUser() {

		try {
			finalUser = ProxyFactory.getProxyInstance("FilteredUserProxyFactory",
					new User(), this.shuttle);

			Map<String, Object> methods = (Map<String, Object>) this.shuttle
					.getValue("methods");
			methods.forEach((k, v) -> {
				try {
					Method method = null;
					try {
						method = this.finalUser.getClass().getMethod(k, String.class);
					} catch (NoSuchMethodException e) {
						try {
							method = this.finalUser.getClass().getMethod(k,
									Integer.class);
						} catch (NoSuchMethodException e1) {
							e1.printStackTrace();
						}
					}
					method.invoke(finalUser, v);
				} catch (SecurityException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}

			});

		} catch (FindErrorException e) {
			e.printStackTrace();
		}

	}

	public User getPrimeUser() {
		return this.primeUser;
	}

	public User getUser() {
		if (this.finalUser == null) {
			processUser();
		}
		return this.finalUser;
	}

	public Dao<User> getDao() {
		return dao;
	}

	public void setDao(Dao<User> dao) {
		this.dao = dao;
	}

	public String getId() {
		return primeUser.getId();
	}

	public UserFaker setId(String id) {
		primeUser.setId(id);
		return this;
	}

	public Date getCreate_date() {
		return primeUser.getCreate_date();
	}

	public UserFaker setCreate_date(Date create_date) {
		primeUser.setCreate_date(create_date);
		return this;
	}

	public Integer getAge() {
		return primeUser.getAge();
	}

	public UserFaker setAge(Integer age) {
		primeUser.setAge(age);
		return this;
	}

	public String getUsername() {
		return primeUser.getUsername();
	}

	public UserFaker setUsername(String username) {
		primeUser.setUsername(username);
		return this;
	}

	public String getPassword() {
		return primeUser.getPassword();
	}

	public UserFaker setPassword(String password) {
		primeUser.setPassword(password);
		return this;
	}

	public String getDisplay_name() {
		return primeUser.getDisplay_name();
	}

	public UserFaker setDisplay_name(String dsiplay_name) {
		primeUser.setDisplay_name(dsiplay_name);
		return this;
	}

	public Integer getGender() {
		return primeUser.getGender();
	}

	public UserFaker setGender(Integer gender) {
		primeUser.setGender(gender);
		return this;
	}

	public String getAuth() {
		return primeUser.getAuth();
	}

	public UserFaker setAuth(String auth) {
		primeUser.setAuth(auth);
		return this;
	}

	public String getTag() {
		return primeUser.getTag();
	}

	public UserFaker setTag(String age) {
		primeUser.setTag(age);
		return this;
	}

	public void create() throws SQLException {
		dao.create(this.primeUser);
		this.queryByUsernameAndPassword();
	}

	public void update(Object id) throws SQLException {
		dao.update(this.primeUser, id);
	}

	public void delete() {
		dao.delete(this.primeUser.getId());
	}

	public User queryById() throws FindErrorException {
		return dao.queryById(this.primeUser.getId());
	}

	public boolean queryByUsernameAndPassword() {
		List<User> list = dao.querySQL(
				"select * from user where username=? and password=? ",
				primeUser.getUsername(), primeUser.getPassword());
		boolean isEmpty = list.isEmpty();
		if (isEmpty) {
			return false;
		} else {
			this.primeUser = list.get(0);
			return true;
		}
	}

	public List<User> queryAll() {
		return dao.queryAll();
	}

	@Override
	public String toString() {
		return "UserFaker [user=" + primeUser + ", shuttle=" + shuttle + ", dao=" + dao
				+ ", sessionValues=" + sessionValues + "]";
	}

}
