package test2;

import java.util.function.Supplier;

import idv.excpetion.ExceptionFactory;

public class Book extends Product<Integer> {


	private String name;
	private Integer price;

	public Object getNew(Supplier supr) {
		return supr.get();
	}

	public void testThrow() {
		throw ExceptionFactory
				.getDefaultUnsupportedOperationException(new Object() {
				});

	}

	public static Object getSupplier(Supplier supr) {

		return supr.get();
	}

}
