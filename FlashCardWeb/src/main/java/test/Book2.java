package test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Book2 {
	private static Book2 book = new Book2();

	private String bookName;

	public Book2() {

	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getSingleBookName() {
		return book.getBookName();
	}

	public void setSingleBookName(String name) {
		book.setBookName(name);
	}

	@Test
	public void test() {
		Book2 b = new Book2();
		b.setSingleBookName("PHP");
		System.out.println(b.getSingleBookName());

		Book2 b2 = new Book2();
		b2.setSingleBookName("Java");
		System.out.println(b.getSingleBookName());
		System.out.println(b2.getSingleBookName());

	}

}
