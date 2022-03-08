package idv.fc.model;

import java.sql.Date;

public class User {
	private String id;// {pk,not null,unique}
	private String username;// {not null,unique}
	private String password;// {not null}
	private String dsiplay_name;
	private Integer gender;
	private Integer age;
	private String authority;
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

	public String getDsiplay_name() {
		return dsiplay_name;
	}

	public void setDsiplay_name(String dsiplay_name) {
		this.dsiplay_name = dsiplay_name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String age) {
		this.tag = age;
	}

}
