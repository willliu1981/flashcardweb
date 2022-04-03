package gameobject.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import gameobject.adapter.AdapterI;
import gameobject.tool.AdapterListConverter;
import idv.tool.Debug;

public class MyTest2 {

	public static class Book {
		String name;

		public Book() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Book(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Book [name=" + name + "]";
		}
		

	}

	public static class BookAdapter extends Book implements AdapterI<Book> {
		Book b;

		public BookAdapter() {

		}

		public BookAdapter(Book b) {

			this.b = b;
		}

		public String getName() {
			return b.getName();
		}

		public void setName(String name) {
			b.setName(name);
		}

		@Override
		public void setTarget(Book t) {
			this.b = t;

		}

		@Override
		public Book getTarget() {
			return this.b;
		}

		@Override
		public String toString() {
			return "BookAdapter [b=" + b + "]";
		}
		
		

	}

	@Test
	public void test() {
		Book b1 = new Book("Java");
		Book b2 = new Book("PHP");
		Book b3 = new Book("C#");
		List<Book> bs = new ArrayList<>();
		bs.add(b1);
		bs.add(b2);
		bs.add(b3);

		List<BookAdapter> adpts = AdapterListConverter.convert(bs, BookAdapter.class);
		adpts.forEach(e -> Debug.test(e));

	}
}
