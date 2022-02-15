package idv.kwl.model;

import java.io.Serializable;

public class User implements Serializable {
	private String uid;
	private String name;
	private String username;
	private String password;
	

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

	public String getUid() {
		return uid;
	}

	public void setUid(String id) {
		this.uid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + uid + ", name=" + name + ", username=" + username
				+ ", password=" + password + "]";
	}

}
