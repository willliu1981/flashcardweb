package test1;

public class Test1 {

	static class Book {
		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	public static void main(String[] args) {
		Book b = new Book();
		b.setName("java");
		
		m(b);

		System.out.println(b.getName());

	}

	public static String m(Book b) {
		b.setName("php");
		return "ok";
	}

}
