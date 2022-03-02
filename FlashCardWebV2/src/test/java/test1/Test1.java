package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {

	static class Book {
		int id;
		String name;

		public Book(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

	}

	public static void main(String[] args) {

		Book[] bs1 = { new Book(1, "a"), new Book(2, "b") };
		Book[] bs2 = { new Book(1, "c") };

		List<Book> bbs = Arrays.asList(Arrays.asList(bs1), Arrays.asList(bs2)).stream()
				.flatMap(Collection::stream).collect(Collectors.toList());
		
		List<Book> bbs2=new ArrayList<>();
		
		Collections.addAll(bbs2);

		System.out.println(bbs);
	}

}
