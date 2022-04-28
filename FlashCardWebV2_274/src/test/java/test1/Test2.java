package test1;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test2 {
	Logger logger = LoggerFactory.getLogger(Test2.class);

	public static void main(String[] args) {
		//test1();
		test2();

	}

	public static void test1() {
		//while 迴圈
		Scanner scanner = new Scanner(System.in);
		System.out.println("input:");

		int input = scanner.nextInt();
		int count = 0;
		while (count <= input) {
			System.out.println(count + ".Hello");
			count++;
		}
	}

	public static void test2() {
		//巢狀 while 迴圈
		Scanner scanner = new Scanner(System.in);
		System.out.println("input:");
		//...
	}

	static class A {
		static int t1 = 0;
		String msg;

		A() {

		}

		A(String s) {

			msg = s;
		}
	}

	static class B extends A {
		static String a;
		static String b = "B";

	}

	static class C extends B {
		static String x = "X1";
		static String x2;

		int num = 3;

		int num2;

		public C(int i) {

			super();

			num = i;

		}

		public C(String a) {

		}
	}

	@Test
	public void testCallPather() {

		int[] a = { 1, 2, 3 };
		Object o = a;
		try {
			Object[] cast = (Object[]) o;
			System.out.println(cast);

		} catch (ClassCastException e) {
			System.out.println("xxx" + a);
		}

	}

}
