package responsibilitytest;

public class Test1 {

	interface IBook {

	}

	static class Store {
		IBook book = new Book();

		public <T extends IBook> T getBook() {
			return (T) book;
		}

	}

	static class Book implements IBook {

		public void m() {
			System.out.println("m...");
		}
	}

	static class Book2 implements IBook {

		public void m() {
			System.out.println("m...");
		}
	}

	public static void main(String[] args) {
		Store store = new Store();

		Book book = store.getBook();
		book.m();

	}

}
