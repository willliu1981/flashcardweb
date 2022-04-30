package test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.JdkIdGenerator;
import org.springframework.util.SimpleIdGenerator;

import idv.fc.model.Flashcard;
import tool.Debug;
import tool.idgenerator.IDGenerator;
import tool.spring.MySpringUtil;

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

	@Test
	public void testx2() {
		String qq = "1882345";
		//String regex = "[1-9]\\d{4,14}";//這是正規表示式的規則 
		String regex = "[1-9]{3,14}";//這是正規表示式的規則 
		Boolean flag = qq.matches(regex);
		System.out.println("xxxxxxxxx");
		if (flag) {
			System.out.println(qq + "...is ok");
		} else {
			System.out.println(qq + "...is not ok");
		}

	}

	@Test
	public void testx3() {
		/*int[] is = { 1, 2, 3 };
		Object o = is;
		
		Object[] os = (Object[]) o;
		System.out.println(os);*/

		Object[] os = { 1, 2, 3 };
		Object o = os;
		int[] is = (int[]) o;

		System.out.println(is);
	}

	@Test
	public void testx4() {
		String st1 = "apple is a fruit";
		String id1 = "fc_" + st1 + "_" + UUID.randomUUID();
		String st2 = "apple is a fruit";
		String id2 = "fc_" + st2 + "_" + UUID.randomUUID();

		List<String> ids = new ArrayList<>();
		ids.add(id1);
		ids.add(id2);

		String[] split = id1.split(" ", 2);

		Debug.test(split.length, split);

		int a = 0;

		logger.info("name=" + Test2.class.getSimpleName());

	}

	@Test
	public void testSwitch() {

		String type = " ";

		logger.info("type= " + type.isEmpty());

	}

	@Test
	public void testIDGen() {
		MySpringUtil.loadXml("test2");
		IDGenerator bean = MySpringUtil.getBean("IDGenerator",
				IDGenerator.class);

		String generate = bean.generate("abc def", Flashcard.class);
		String generate2 = bean.generate("abc def", Flashcard.class);

		logger.info("bean=" + generate);
		logger.info("bean=" + generate2);

	}

	@Test
	public void testIDGen2() {
		SimpleIdGenerator g1 = new SimpleIdGenerator();
		logger.info("SimpleIdGenerator g1=" + g1.generateId().randomUUID());

		JdkIdGenerator g2 = new JdkIdGenerator();
		logger.info("JdkIdGenerator g2=" + g2.generateId().randomUUID());

		AlternativeJdkIdGenerator g3 = new AlternativeJdkIdGenerator();
		logger.info("AlternativeJdkIdGenerator g3=" + g3.generateId().randomUUID());

		logger.info("xxx");

		SimpleIdGenerator g12 = new SimpleIdGenerator();
		logger.info("SimpleIdGenerator g12=" + g12.generateId().randomUUID());

		JdkIdGenerator g22 = new JdkIdGenerator();
		logger.info("JdkIdGenerator g22=" + g22.generateId().randomUUID());

		AlternativeJdkIdGenerator g32 = new AlternativeJdkIdGenerator();
		logger.info("AlternativeJdkIdGenerator g32=" + g32.generateId().randomUUID());

		
	}
	
	@Test
	public void testx5() {
		String st1 = "apple is a fruit";
		String id1 = "fc_" + st1 + "_" + UUID.randomUUID();


		
		String replaceAll = id1.replaceAll("[fc_]", "");

		logger.info("id1=" +id1);
		logger.info("replaceAll=" +replaceAll);


	}

}
