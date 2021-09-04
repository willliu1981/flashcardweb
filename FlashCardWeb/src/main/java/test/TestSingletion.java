package test;

public class TestSingletion {

	static class Book {
		static private Book book=new Book();
		private String name;

		public String getName() {
			return book.name;
		}

		public void setName(String name) {
			book.name = name;
		}
		
	}
	
	public static void main(String[] args) {
		Book b1=new Book();
		b1.setName("PHP");
		
		System.out.println(b1.getName());
		
		Book b2=new Book();
		b2.setName("Java");
		System.out.println(b1.getName() +","+b2.getName());

	}

}
