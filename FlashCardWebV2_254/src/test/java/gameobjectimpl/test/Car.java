package gameobjectimpl.test;

import java.util.Map;

import idv.tool.Debug;

public class Car {
	private static String logo;
	private Map<String, String> components;

	private String name;

	public Car() {

	}

	public Car(String name) {
		this.name = name;
		Debug.test(this, "constructor");
	}

	public static String getLogo() {
		return logo;
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

	public Map<String, String> getComponents() {
		return components;
	}

	public void setAddComponents(Map<String, String> components) {
		this.components = components;
	}

}
