package test6;

import idv.tool.Debug;

public class Test1 {

	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();

		BeanBuilderInfo builder1 = new BeanBuilderInfo();
		builder1.setId("Car1");
		builder1.setClassString("test6.Car");
		builder1.setBaseProperty("setName", "CarA");
		builder1.setClassProperty("setDriver", "Driver1");

		factory.addBuilderInfo(builder1);

		BeanBuilderInfo builder2 = new BeanBuilderInfo();
		builder2.setId("Driver1");
		builder2.setClassString("test6.Driver");
		builder2.setBaseProperty("setName", "Peter");

		factory.addBuilderInfo(builder2);

		factory.configure();

		Car car = (Car) factory.getBean("Car1");
		Debug.test(car);

		Driver driver = (Driver) factory.getBean("Driver1");
		Debug.test(driver);

	}

}
