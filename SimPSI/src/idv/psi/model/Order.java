package idv.psi.model;

public class Order {
	private static int MAXDISPLAYITEMCOUNT = 10;
	private Integer orderNumber;//單號
	private ProductItem[] items;//項目數量
	private int currentItemPointer;//當前新增項目數量

	private static Integer currentOrderIndex = 1;//目前單號

	public Order() {
		autoNumber();
		items = new ProductItem[MAXDISPLAYITEMCOUNT];
	}

	private void autoNumber() {
		this.orderNumber = currentOrderIndex;
		currentOrderIndex++;
	}

	public boolean addProductItem(Product product, Integer count) {
		int productCount = Inventory
				.getProductQuantityWithProductID(product.getId());
		if (count > productCount) {
			return false;
		} else {
			items[currentItemPointer] = new ProductItem(product, count);
			Inventory.consume(product.getId(), count);

			currentItemPointer++;
		}

		return true;
	}

	public ProductItem[] getProductItems() {
		return this.items;
	}

	//取得項目數量
	public int getItemCount() {
		return this.currentItemPointer;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer number) {
		this.orderNumber = number;
	}

	//取得最後一筆新增的項目
	public String getCurrentItemDisplay() {
		int lastIndex = this.getItemCount() - 1;
		return getItemDisplayWithIndex(lastIndex);
	}

	public String getItemDisplayWithIndex(int index) {
		StringBuilder sb = new StringBuilder();
		ProductItem item = this.items[index];

		sb.append(index + 1).append(":").append(item.getProduct().getName())
				.append(" x").append(item.getQuantity());

		return sb.toString();
	}

	//取得訂單明細
	public String getOrderDisplay() {
		StringBuilder sb = new StringBuilder();
		sb.append("單號:").append(this.orderNumber).append("\n");

		int index = 0;
		int costTotal = 0;
		while (index < this.getItemCount()) {
			sb.append("  ").append(this.getItemDisplayWithIndex(index))
					.append("\n");

			ProductItem item = this.items[index];
			int cost = item.getProduct().getPrice() * item.getQuantity();
			costTotal += cost;
			index++;
		}
		sb.append("總計:" + costTotal);

		return sb.toString();

	}
}
