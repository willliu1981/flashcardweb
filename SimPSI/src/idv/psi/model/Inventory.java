package idv.psi.model;

public class Inventory {

	private static Product[] products;

	private Inventory() {

	}

	public static void initialize(Integer maxProductsCount) {
		products = new Product[maxProductsCount];
	}

	public static void setProduct(Integer index, Product product) {
		products[index] = product;
	}

	public static String display() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < products.length; i++) {
			sb.append("[").append(i).append(":")
					.append(Inventory.products[i] == null ? "尚未有項目"
							: Inventory.products[i].getName())
					.append("]");

			if (i < Inventory.products.length - 1) {
				sb.append(" ");
			}
		}

		return sb.toString();
	}

}
