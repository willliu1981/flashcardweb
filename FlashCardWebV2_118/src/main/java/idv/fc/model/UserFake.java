package idv.fc.model;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import idv.fc.dao.abstraction.Dao;
import idv.fc.tool.SpringUtil;

public class UserFake {

	private User user;

	Dao<User> dao;

	public UserFake() {
		user = (User) SpringUtil.getBean("EmptyUser");
		dao = (Dao<User>) SpringUtil.getBean("UserCommonDao");

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Dao<User> getDao() {
		return dao;
	}

	public void setDao(Dao<User> dao) {
		this.dao = dao;
	}

	public String getId() {
		return user.getId();
	}

	public UserFake setId(String id) {
		user.setId(id);
		return this;
	}

	public Date getCreate_date() {
		return user.getCreate_date();
	}

	public UserFake setCreate_date(Date create_date) {
		user.setCreate_date(create_date);
		return this;
	}

	public Integer getAge() {
		return user.getAge();
	}

	public UserFake setAge(Integer age) {
		user.setAge(age);
		return this;
	}

	public String getUsername() {
		return user.getUsername();
	}

	public UserFake setUsername(String username) {
		user.setUsername(username);
		return this;
	}

	public String getPassword() {
		return user.getPassword();
	}

	public UserFake setPassword(String password) {
		user.setPassword(password);
		return this;
	}

	public String getDisplay_name() {
		return user.getDisplay_name();
	}

	public UserFake setDisplay_name(String dsiplay_name) {
		user.setDisplay_name(dsiplay_name);
		return this;
	}

	public Integer getGender() {
		return user.getGender();
	}

	public UserFake setGender(Integer gender) {
		user.setGender(gender);
		return this;
	}

	public String getAuthority() {
		return user.getAuthority();
	}

	public UserFake setAuthority(String authority) {
		user.setAuthority(authority);
		return this;
	}

	public String getTag() {
		return user.getTag();
	}

	public UserFake setTag(String age) {
		user.setTag(age);
		return this;
	}

	public void create() {
		dao.create(this.user);
	}

	public void update(Object id) {
		dao.update(this.user, id);
	}

	public void delete(Object id) {
		dao.delete(id);
	}

	public User queryById(Object id) {
		return dao.queryById(id);
	}

	public boolean queryByUsernameAndPassword() {
		List<User> list = dao.querySQL(
				"select * from user where username=? and password=? ",
				user.getUsername(), user.getPassword());
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

}
