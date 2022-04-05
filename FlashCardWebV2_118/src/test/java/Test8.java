import java.util.Arrays;
import java.util.List;

import idv.tool.Debug;

public class Test8 {

	static class Book {
		int price;

		public Book() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Book(int price) {
			super();
			this.price = price;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

	}

	public static void main(String[] args) {
		List<Book> prices = Arrays.asList(new Book(123), new Book(45), new Book(66));

		Book result = prices.stream().collect(Book::new,
				(x, y) -> x.setPrice(x.getPrice() + y.getPrice()),
				(a, b) -> a.setPrice(a.getPrice() + b.getPrice()));
		
		//Debug.test(result.getPrice());

		Book total = prices.stream().collect(Book::new, (x, y) -> x.setPrice(x.getPrice() + y.getPrice()),
				(a, b) -> a.setPrice(a.getPrice() + b.getPrice()));

		/*
		List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
		
		// sequential stream - nothing to combine
		StringBuilder result = vowels.stream().collect(StringBuilder::new,
				(x, y) -> x.append(y), (a, b) -> a.append(",").append(b));
		System.out.println(result.toString());
		
		// parallel stream - combiner is combining partial results
		StringBuilder result1 = vowels.parallelStream().collect(StringBuilder::new,
				(x, y) -> x.append(y), (a, b) -> a.append(",").append(b));
		System.out.println(result1.toString());
		//*/
	}

}
