package test3;

import org.junit.jupiter.api.Test;

import tool.Debug;

public class Test1 {

	public static class Car {

		public void testM(String name, String body, String... params) {
			Debug.test(name,body,params);
		}
	}

	@Test
	public void test1() {
		Car car = new Car();

		car.testM("aa", "xxx", "p1", "p2");
	}
}
