package test8;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import idv.tool.Debug;

public class Store {
	String name;

	List<Product> ps = new ArrayList<>();

	public void add(Product p) {
		ps.add(p);
	}

	public Product get(int index) {
		return ps.get(index);
	}

	public void showProducts() {
		ps.forEach(System.out::println);
		Debug.test(this, ps);
	}

	@Test
	public void test() {
		showProducts();
	}
}
