package test8;

public abstract class Product {
	abstract String getName();

	@Override
	public String toString() {
		return "Product [getName()=" + getName() + "]";
	}
	
	
}
