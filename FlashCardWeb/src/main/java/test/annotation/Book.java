package test.annotation;

import test.annotation.AnnoBookInfo.BookType;

class Book {
	private BookType bookType;
	private String name;

	@AnnoBookAuthor(author = "test.annotation.Author1", name = "John")
	private Author author;

	public void show() {
		System.out.println("book author name =" + author.getName());

	}

}