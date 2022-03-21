package test5;

public class User {
	String name;

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
