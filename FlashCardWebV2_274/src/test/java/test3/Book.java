package test3;

import java.util.List;

public class Book<T> extends Product {
	private String name;
	private int price;
	List<T> datas;

	public Book(String name, int price, List<T> datas) {
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
