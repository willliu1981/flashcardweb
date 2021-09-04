package test;

import org.springframework.beans.factory.annotation.Autowired;

public class Book {
	private String bookName ;
	
	@Autowired
	private Author author;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	

	

	


}
