package test7;

import java.util.Map;

import idv.tool.Debug;

public class Car implements CarI {
	private Map<String,String> components;

	private String name;

	public Car() {
		Debug.test("ccccccc");
	}

	public Car(String name) {
		this.name = name;
		//Debug.test(this, "constructor");
	}

	public void setName(String name) {
		this.name = name;
		//Debug.test(this, "setName");
	}

	public String getName() {
		return name;
	}

	public void init() {
		//Debug.test(this, "init");
	}

	public Map<String, String> getComponents() {
		return components;
	}

	public void setAddComponents(Map<String, String> components) {
		this.components = components;
	}

}
