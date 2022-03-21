package idv.test;

public class Car {

	private String name;


	Car() {
		this.name = "default";
	}

	Car(String name) {
		this.name = name;
	}

	Car(String name, String name2) {
		this.name = name + "-" + name2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + "]";
	}

}
