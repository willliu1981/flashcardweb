package gameobject.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import idv.tool.Debug;

//@TestMethodOrder(OrderAnnotation.class)
public class MyTest {


	@BeforeEach
	public void init() {
		Debug.test("xx0");
	}

	//@Order(2)
	@Test
	//@DisplayName("tttt")
	public void test() {
		Debug.test("xx1:" );
	}

	@Order(1)
	//@Disabled
	@Test
	//@RepeatedTest(5)   
	public void test2() {
		Debug.test("xx2");
	}

	public static int[][] data() {
		return new int[][] { { 1, 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
	}

	@ParameterizedTest
	@MethodSource(value = "data")
	void testWithStringParameter(int[] data) {
		MyClass tester = new MyClass();
		int m1 = data[0];
		int m2 = data[1];
		int expected = data[2];
		assertEquals(expected, tester.multiply(m1, m2));
	}

	// class to be tested
	class MyClass {
		public int multiply(int i, int j) {
			return i * j;
		}
	}

}
