package test1;

import java.util.HashMap;
import java.util.Map;

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

		@Override
		public String toString() {
			return "Book [id=" + id + ", name=" + name + "]";
		}

	}

	public static void main(String[] args) {

		/*
		Book[] bs1 = { new Book(1, "a"), new Book(2, "b") };
		Book[] bs2 = { new Book(1, "c") };
		
		List<Book> bbs = Arrays.asList(Arrays.asList(bs1), Arrays.asList(bs2)).stream()
				.flatMap(Collection::stream).collect(Collectors.toList());
		
		List<Book> bbs2=new ArrayList<>();
		
		Collections.addAll(bbs2);
		
		System.out.println(bbs);
		//*/

		Book b1 = new Book(1, "A");
		Book b2 = new Book(2, "B");

		Map<Object, Book> books = new HashMap<>();
		String kstr=new String("a");
		books.put(kstr, b1);
		books.put("b", b2);
		
		Object k=new String("a") ;
		String kkstr="a";
		
		System.out.println(books.get(kkstr));

	}

}
