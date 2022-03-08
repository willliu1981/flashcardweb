package idv.fc.model;

public class User {
	private String id;// not null
	private String username;// not null
	private String password;// not null
	private String dsiplay_name;// not null
	private Integer gender;// not null
	private Integer age;// not null
	private Integer authority;
	private String tag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Integer getAuthority() {
		return authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String age) {
		this.tag = age;
	}

}
