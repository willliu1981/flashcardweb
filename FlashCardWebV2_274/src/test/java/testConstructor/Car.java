package testConstructor;

import tool.Debug;

public class Car {
	private String name;

	public Car(String name) {
		this.name = name;
	}

	public void testM(String name, String body, String... params) {
		Debug.test(name, body, params);
	}

	@Override
	public String toString() {
		return "Car [name=" + name + "]";
	}
}
