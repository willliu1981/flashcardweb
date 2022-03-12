package idv.fc.test;

import java.lang.reflect.Method;
import java.sql.Date;
import java.util.List;

import idv.fc.dao.abstraction.Dao;
import idv.fc.model.User;
import idv.fc.proxy.InterceptorAdapter;
import idv.fc.proxy.ProxyFactory;
import idv.fc.tool.SpringUtil;
import net.sf.cglib.proxy.MethodProxy;

public class NewUserFaker extends Faker {

	/**
	 * 這個建構子保留給反射機制專用
	 */
	public NewUserFaker() {
		this.createFaker((NewUserFaker) SpringUtil.getBean("NewUserFaker"));
	}

	/**
	 * 使用 servlet.xml 須使用這個建構子
	 * @param obj
	 */
	public NewUserFaker(Object obj) {
		this.createFaker(this);
	}

	private void init() {
		User getUser = (User) SpringUtil.getBean("EmptyUser");
		this.setDao((Dao<User>) SpringUtil.getBean("UserCommonDao"));

		this.getRealFaker().setUser(
				(User) ProxyFactory.getProxyInstance(new InterceptorAdapter<User>() {

					@Override
					public Object intercept(Object obj, Method method, Object[] args,
							MethodProxy proxy) throws Throwable {
						boolean flag = true;
						Object value = null;

						if (proxy.getSignature().getName().equals("setAuthority")) {

							flag = false;
						}

						if (flag) {
							value = method.invoke(this.getTarget(), args);
						}

						return value;
					}

				}.setTarget(getUser())));
	}

	public String getId() {
		return getUser().getId();
	}

	public NewUserFaker setId(String id) {
		getUser().setId(id);
		return this;
	}

	public Date getCreate_date() {
		return getUser().getCreate_date();
	}

	public NewUserFaker setCreate_date(Date create_date) {
		getUser().setCreate_date(create_date);
		return this;
	}

	public Integer getAge() {
		return getUser().getAge();
	}

	public NewUserFaker setAge(Integer age) {
		getUser().setAge(age);
		return this;
	}

	public String getUsername() {
		return getUser().getUsername();
	}

	public NewUserFaker setUsername(String username) {
		getUser().setUsername(username);
		return this;
	}

	public String getPassword() {
		return getUser().getPassword();
	}

	public NewUserFaker setPassword(String password) {
		getUser().setPassword(password);
		return this;
	}

	public String getDisplay_name() {
		return getUser().getDisplay_name();
	}

	public NewUserFaker setDisplay_name(String dsiplay_name) {
		getUser().setDisplay_name(dsiplay_name);
		return this;
	}

	public Integer getGender() {
		return getUser().getGender();
	}

	public NewUserFaker setGender(Integer gender) {
		getUser().setGender(gender);
		return this;
	}

	public String getAuthority() {
		return getUser().getAuthority();
	}

	public NewUserFaker setAuthority(String authority) {
		getUser().setAuthority(authority);
		return this;
	}

	public String getTag() {
		return getUser().getTag();
	}

	public NewUserFaker setTag(String age) {
		getUser().setTag(age);
		return this;
	}

	public void create() {
		getDao().create(this.getUser());
		this.queryByUsernameAndPassword();
	}

	public void update(Object id) {
		getDao().update(this.getUser(), id);
	}

	public void delete() {
		getDao().delete(this.getUser().getId());
	}

	public User queryById() {
		return getDao().queryById(this.getUser().getId());
	}

	public boolean queryByUsernameAndPassword() {
		List<User> list = getDao().querySQL(
				"select * from getUser() where username=? and password=? ",
				getUser().getUsername(), getUser().getPassword());
		boolean isEmpty = list.isEmpty();
		if (isEmpty) {
			return false;
		} else {
			this.setUser(list.get(0));
			return true;
		}
	}

	public List<User> queryAll() {
		return getDao().queryAll();
	}

}
