package test1;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import tool.Debug;

public class Test3 {

	static boolean a;
	static boolean b = false;
	static boolean c = true;
	static String msg = "xxx";
	int ss = 1;
	boolean b1;
	String m2;

	static {
		a = true;
	}

	Test3() {
		b1 = c;
		m2 = msg;
	}

	public static void main(String[] args) {

		Test3 t3 = new Test3();
		Test3 test3 = new Test3();
		Class c = String.class;
	}

	static class Book {
		String name;
	}

	@Test
	public void testx1() {

		Book[] books1 = null;

		int identityHashCode1 = System.identityHashCode(books1);

		System.out.println("id1=" + identityHashCode1);

		Book[] books2 = new Book[3];

		int identityHashCode2 = System.identityHashCode(books2);

		System.out.println("id2=" + identityHashCode2);

		Book[] books3 = null;

		int identityHashCode3 = System.identityHashCode(books3);

		System.out.println("id3=" + identityHashCode3);

		/*
		books[0].name="A";
		
		books[1].name="B";
		
		books[1].name="C";
		
		
		
		
		for (Book book : books) {
			
			
			System.out.println(book.name);
		
		}
		
		for (int i = 0; i < books.length; i++) {
			Book book = books[i];
			System.out.println(book.name);
		}
		//*/
	}

	static class Car {
		String name;
	}

	static class EBook extends Book {

	}

	@Test
	public void testx2() {

		Debug.test(Math.pow(3, 2));

	}

	@Test
	public void testx3() {

		List<String> strs = new ArrayList<>();
		strs.add("x");
		strs.add("y");
		strs.add("z");

		String reduce = strs.stream().reduce((x1, x2) -> x1 + "," + x2).get();
		Debug.test(reduce);

	}

	@Test
	public void testx4() {
		Person p = new Person();
		p.setInfoData("xxx");
		Data msg = new Data("sssss");
		p.setMsg(msg);
		MyInteger myInteger = new MyInteger(666);
		p.setMyNumber(myInteger);
		p.setNumber(3331);
		p.setNum(3332);

		Debug.test(this, p);
	}

}
