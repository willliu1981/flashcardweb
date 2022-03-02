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
	

		System.out.println("xxxx");

	}
	
	public static void test() {
		System.out.println("xxxx1");
		
	}

	public static String m(Book b) {
		b.setName("php");
		return "ok";
	}

}
