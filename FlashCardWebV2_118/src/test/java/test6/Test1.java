package test6;

import idv.tool.Debug;

public class Test1 {

	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();

		BeanBuilderInfo builder1 = new BeanBuilderInfo();
		builder1.setId("Car1");
		builder1.setClassString("test6.Car");
		builder1.setBaseProperty("setName", "CarA");

		factory.addBuilderInfo(builder1);

		factory.configure();

		Car car = (Car) factory.getBean("Car1");

		Debug.test(car);

	}

}
