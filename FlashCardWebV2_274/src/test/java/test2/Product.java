package test2;

public class Product<T> implements IProduct {
	T t;

	public Product() {
	}

	public Product(T t) {
		this.t = t;
	}
}
