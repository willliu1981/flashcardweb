package test6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import idv.tool.Debug;

public class Test2 {

	public static void main(String[] args) {
		Car car = new Car();
		try {
			Method me = car.getClass().getMethod("setName", String.class);
			me.invoke(car, "CCC");
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		Debug.test(car);

	}

}
