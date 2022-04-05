package test7;

import idv.tool.Debug;

public class Car implements CarI {

	private String name;

	public Car() {
		
	}

	public Car(String name) {
		this.name = name;
		Debug.test(this, "constructor");
	}

	public void setName(String name) {
		this.name = name;
		Debug.test(this, "setName");
	}

	public String getName() {
		return name;
	}

	public void init() {
		Debug.test(this, "init");
	}

}
