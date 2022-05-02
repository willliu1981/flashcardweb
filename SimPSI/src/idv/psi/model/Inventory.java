package idv.psi.model;

public class Inventory {

	private static Product[] products;
	private static int[] productQuantity;//產品存量

	private Inventory() {

	}

	public static void initialize(Integer maxProductsCount) {
		products = new Product[maxProductsCount];
		productQuantity = new int[maxProductsCount];
	}

	//product id = products 的 index+1
	private static int getIndexWithProductID(int productID) {
		return productID - 1;
	}

	public static void setProduct(Product product, int quantity) {
		int index = getIndexWithProductID(product.getId());
		products[index] = product;
		productQuantity[index] = quantity;
	}

	public static void consume(int productID, int count) {
		productQuantity[getIndexWithProductID(productID)] -= count;
	}

	//是否有這項產品
	public static boolean isExistCategory(int productID) {
		if (productID < 1 || productID > products.length) {
			return false;
		}

		return products[getIndexWithProductID(productID)] != null;
	}

	public static int getProductQuantityWithProductID(int productID) {
		return productQuantity[getIndexWithProductID(productID)];
	}

	public static String getDisplayForTitle() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < products.length; i++) {
			sb.append("[").append(i + 1).append(":")
					.append(Inventory.products[i] == null ? "尚未有項目"
							: Inventory.products[i].getName())
					.append("]");

			if (i < Inventory.products.length - 1) {
				sb.append(" ");
			}
		}

		return sb.toString();
	}

	public static String getDisplay() {
		StringBuilder sb = new StringBuilder();
		sb.append("庫存:").append("\n");
		for (int i = 0; i < products.length; i++) {
			boolean isEmpty = Inventory.products[i] == null;
			sb.append(i + 1).append(":");
			if (isEmpty) {
				sb.append("尚未有項");
			} else {
				sb.append(Inventory.products[i].getName()).append("  ")
						.append(productQuantity[i]);
			}

			sb.append("\n");
		}

		return sb.toString();
	}

	public static int getItemCount() {
		return Inventory.products.length;
	}

	public static int getProductQuantity(int productID) {
		return Inventory.productQuantity[getIndexWithProductID(productID)];
	}

	public static Product getProduct(int productID) {
		return Inventory.products[getIndexWithProductID(productID)];
	}

	//回朔庫存
	public static void rollback(Order order) {
		ProductItem[] productItems = order.getProductItems();
		for (int i = 0; i < order.getItemCount(); i++) {
			ProductItem productItem = productItems[i];
			Inventory.productQuantity[getIndexWithProductID(
					productItem.getProduct().getId())] += productItem
							.getQuantity();
		}

	}

}
