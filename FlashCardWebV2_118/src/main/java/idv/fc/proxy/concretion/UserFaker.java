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

	private User user;
	private User userTemp = null;
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
			this.user = ProxyFactory.getProxyInstance("PreparedUserProxyFactory", user,
					this.shuttle);

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

	public void intercept() {

		try {
			userTemp = ProxyFactory.getProxyInstance("FilteredUserProxyFactory",
					new User(), this.shuttle);

			Map<String, Object> methods = (Map<String, Object>) this.shuttle
					.getValue("methods");
			methods.forEach((k, v) -> {
				try {
					Method method = null;
					try {
						method = this.userTemp.getClass().getMethod(k, String.class);
					} catch (NoSuchMethodException e) {
						try {
							method = this.userTemp.getClass().getMethod(k,
									Integer.class);
						} catch (NoSuchMethodException e1) {
							e1.printStackTrace();
						}
					}
					method.invoke(userTemp, v);
				} catch (SecurityException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}

			});
			this.user = this.userTemp;
		} catch (FindErrorException e) {
			e.printStackTrace();
		}

	}

	public User getUser() {
		return this.user;
	}

	public Dao<User> getDao() {
		return dao;
	}

	public void setDao(Dao<User> dao) {
		this.dao = dao;
	}

	public String getId() {
		return getUser().getId();
	}

	public UserFaker setId(String id) {
		getUser().setId(id);
		return this;
	}

	public Date getCreate_date() {
		return getUser().getCreate_date();
	}

	public UserFaker setCreate_date(Date create_date) {
		getUser().setCreate_date(create_date);
		return this;
	}

	public Integer getAge() {
		return getUser().getAge();
	}

	public UserFaker setAge(Integer age) {
		getUser().setAge(age);
		return this;
	}

	public String getUsername() {
		return getUser().getUsername();
	}

	public UserFaker setUsername(String username) {
		getUser().setUsername(username);
		return this;
	}

	public String getPassword() {
		return getUser().getPassword();
	}

	public UserFaker setPassword(String password) {
		getUser().setPassword(password);
		return this;
	}

	public String getDisplay_name() {
		return getUser().getDisplay_name();
	}

	public UserFaker setDisplay_name(String dsiplay_name) {
		getUser().setDisplay_name(dsiplay_name);
		return this;
	}

	public Integer getGender() {
		return getUser().getGender();
	}

	public UserFaker setGender(Integer gender) {
		getUser().setGender(gender);
		return this;
	}

	public String getAuth() {
		return getUser().getAuth();
	}

	public UserFaker setAuth(String auth) {
		getUser().setAuth(auth);
		return this;
	}

	public String getTag() {
		return getUser().getTag();
	}

	public UserFaker setTag(String age) {
		getUser().setTag(age);
		return this;
	}

	public void create() throws SQLException {
		dao.create(this.getUser());
		this.queryByUsernameAndPasswordIsPresentThenSetUser();
	}

	public void update(Object id) throws SQLException {
		dao.update(this.getUser(), id);
	}

	public void delete() {
		dao.delete(this.getUser().getId());
	}

	public User queryById() throws FindErrorException {
		return dao.queryById(this.getUser().getId());
	}

	public boolean queryByUsernameAndPasswordIsPresentThenSetUser() {
		List<User> list = dao.querySQL(
				"select * from user where username=? and password=? ",
				getUser().getUsername(), getUser().getPassword());
		boolean isEmpty = list.isEmpty();
		if (isEmpty) {
			return false;
		} else {
			this.user = list.get(0);
			return true;
		}
	}

	public List<User> queryAll() {
		return dao.queryAll();
	}

	@Override
	public String toString() {
		return "UserFaker [user=" + getUser() + ", shuttle=" + shuttle + ", dao=" + dao
				+ ", sessionValues=" + sessionValues + "]";
	}

}
