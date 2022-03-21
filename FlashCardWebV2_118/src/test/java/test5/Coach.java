package test5;

public class Coach {
	String name;

	public Coach(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Coach [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
