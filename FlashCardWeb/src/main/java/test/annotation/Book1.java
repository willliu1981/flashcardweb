package test.annotation;

import test.annotation.AnnoBookInfo.BookType;

class Book1 extends Book {

	@AnnoBookType
	private BookType bookType;
	@AnnoBookName
	private String name;

	@AnnoBookAuthor(author = "test.annotation.Author1", name = "John")
	private Author author;

	@Override
	public void show() {
		System.out.printf(
				"book type=%s , book name =%s , book author info=%s\n",
				bookType, this.name, author);
	}

}