package testConstructor;

public class BookName implements Name{
	private String bookName;

	@Override
	public String toString() {
		return "BookName [bookName=" + bookName + "]";
	}

	@Override
	public String getBookName() {
		return bookName;
	}

	@Override
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
}
