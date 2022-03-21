package test6;

public class Car {
	String name;
	Driver driver;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", driver=" + driver + "]";
	}
	
	
	
}
