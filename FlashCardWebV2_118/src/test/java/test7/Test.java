package test7;

import idv.tool.Debug;

public class Test {
	
	static class Book{
		private String name;
		Integer a;
	}
	
	static class EBook extends Book{
		private String name;
	}

	public static void main(String[] args) {

		//*
		System.out.println("line1...");
		//*/

		/*
		System.out.println("line2...");
		//*/
		
		Debug.test(new Book().a);
		
	}

}
