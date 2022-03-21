package test6;

import java.lang.reflect.Method;

import idv.tool.Debug;

public class Test3 {

	public static void main(String[] args) {
		Car car = new Car();

		Debug.test(car.getClass().equals(Car.class));

	}

}
