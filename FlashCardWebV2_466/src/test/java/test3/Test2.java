package test3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

import idv.test.TestLog;

public class Test2 extends TestLog {

	static class ToolKit {
		public static EmptyResover getEmptyResover() {
			return new EmptyResover();
		}
	}

	static class EmptyResover {
		public <T> Optional<T> resolve(Supplier<T> resolver) {
			try {
				T result = resolver.get();
				return Optional.ofNullable(result);
			} catch (NullPointerException e) {
				return Optional.empty();
			}
		}
	}

	static class Book {
		String name;

		public Book() {
			super();
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

	}

	static class Store {
		List<Book> books = new ArrayList<>();

		public List<Book> find() {
			return books;
		}

		public Book find(int index) {
			return books.get(index);
		}
	}

	@Test
	public void test1() {

		Store store = new Store();
		store.books.add(new Book());
		
		//情況一:
		if (!store.find().isEmpty() && ToolKit.getEmptyResover()
				.resolve(() -> store.find(0)).isPresent()) {
			System.out.println("找到" + store.find(0));
		} else {
			System.out.println("找不到書");
		}
		
		//情況二: 找到書,但書名為 null
		if (!store.find().isEmpty() && ToolKit.getEmptyResover()
				.resolve(() -> store.find(0).getName()).isPresent()) {
			System.out.println("找到" + store.find(0));
		} else {
			System.out.println("找不到書");
		}

	}
}
