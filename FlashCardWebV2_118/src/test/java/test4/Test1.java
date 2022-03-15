package test4;

import java.util.ArrayList;
import java.util.List;

import idv.fc.tool.Debug;

public class Test1 {
	
	static class Book{
		String name;
		Book(){
			this.name=this.getClass().getSimpleName();
		}
		
	}
	
	static class EBook extends Book{
		EBook(){
			//this.name=this.getClass().getSimpleName();
		}
	}

	public static void main(String[] args) {
		EBook eb=new EBook();
		
		List<Book> books=new ArrayList<>();
		books.add(eb);
		books.add(null);
		books.add(null);
		
		Debug.test(books);

	}

}
