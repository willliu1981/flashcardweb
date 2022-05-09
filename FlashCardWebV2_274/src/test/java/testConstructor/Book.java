package testConstructor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Book<T> extends Product {
	private Name name;
	private int price;
	List<T> datas;

	public Book(Name name, int price, List<T> datas,HttpServletRequest request) {
		this.name = name;
		this.price = price;
		this.datas = datas;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + ", msg=" + datas
				+ "]";
	}

}