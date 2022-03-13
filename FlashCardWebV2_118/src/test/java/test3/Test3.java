package test3;

import idv.fc.tool.Debug;

public class Test3 {

	public static void main(String[] args) {
		Book book = new EBook();
		//book.setTitle((Object) "Java").setMsg((Object) "Hello world!");

		//Debug.test(null, book);

		book.setTitle("PHP");
		

		Debug.test(null, book.getClass());
	}

}

class Book {
	String title;
	String msg;
	String name;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}

class EBook extends Book {

	public EBook setTitle(Object title) {
		super.setTitle((String) title);
		return this;
	}

	public EBook setMsg(Object msg) {
		super.setMsg((String) msg);
		return this;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", msg=" + msg + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	

}