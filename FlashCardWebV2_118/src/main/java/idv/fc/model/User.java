package idv.fc.model;

import java.sql.Date;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import idv.fc.enums.Authority;
import idv.fc.proxy.annotation.Authorized;

@EnableAspectJAutoProxy(proxyTargetClass = true)
public class User {
	private String id;// {pk,not null,unique}
	private String username;// {not null,unique}
	private String password;// {not null}
	private String display_name;
	private Integer gender;
	private Integer age;
	private String auth;
	private String tag;
	private Date create_date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String dsiplay_name) {
		this.display_name = dsiplay_name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getAuth() {
		return auth;
	}

	@Authorized(Authority.ADMIN)
	public void setAuth(String authority) {
		this.auth = authority;
	}

	public String getTag() {
		return tag;
	}

	@Authorized(Authority.ADMIN)
	public void setTag(String age) {
		this.tag = age;
	}

}
