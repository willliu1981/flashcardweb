package idv.psi.main;

import java.util.Scanner;

import idv.psi.model.Inventory;
import idv.psi.model.Order;
import idv.psi.model.Product;

public class Demo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//init start
		int maxProductCategory = 10;//
		Inventory.initialize(maxProductCategory);
		//product id = Inventory 的 products index+1 , 因此需要大於0, 小於或等於 maxProductCategory
		Product p1 = new Product(1, "沙朗牛排", "嚴選最頂級澳洲和牛", 400);
		Product p2 = new Product(2, "松阪豬", "整頭豬最珍貴的地方", 320);
		Product p3 = new Product(3, "脆皮雞排", "外皮煎的香酥脆口，肉汁鮮美不乾硬", 260);
		Inventory.setProduct(p1, 50);
		Inventory.setProduct(p2, 30);
		Inventory.setProduct(p3, 100);

		//init end

		System.out.println(Inventory.getDisplayForTitle());

		System.out.println("新增訂單:按 1  (按-1 離開, 按8 查看庫存)");
		System.out.print("> ");
		int input = sc.nextInt();
		if (input == 1) {
			System.out.println("已創建新單");
			System.out.println();
		}

		Order order = new Order();
		while (true) {

			//新增項目
			if (input == 1) {
				System.out.println("選擇產品:1~" + Inventory.getItemCount());
				System.out.print("> ");
				int index = sc.nextInt();//sc.nextInt() 具有暫停效果, 以下如是
				if (!Inventory.isExistCategory(index)) {
					System.out.println("沒有這項產品!");
					System.out.println();
					input = 2;
					continue;
				}
				System.out.println(
						"已選擇 " + Inventory.getProduct(index).getName());
				System.out.println();
				System.out.println(
						"選擇數量:(" + Inventory.getProductQuantity(index) + ")");
				System.out.print("> ");
				int count = sc.nextInt();
				if (count <= 0) {
					System.out.println("已取消項目");
					System.out.println();
					input = 2;//如同直接到 詢問"是否結帳"
					continue;
				}

				//創建新單
				Product p = Inventory.getProduct(index);
				boolean result = order.addProductItem(p, count);
				if (!result) {
					System.out.println("庫存數量不足!");
					input = 2;//如同直接到 詢問"是否結帳"
					continue;
				}

				System.out.println("已新增項目> " + order.getCurrentItemDisplay());
				System.out.println();
				System.out.println("新增項目:按 1 , 按2 前往下一步,完成訂單");
				System.out.print("> ");
				input = sc.nextInt();

				//是否結帳
			} else if (input == 2) {
				System.out.println("目前訂單明細:");
				System.out.println(order.getOrderDisplay());
				System.out.println();
				System.out.println("追加項目 按1 , 結帳按9 , 棄單按7");
				System.out.print("> ");
				input = sc.nextInt();

				//棄單
			} else if (input == 7) {
				Inventory.rollback(order);
				System.out.println("已放棄訂單");
				System.out.println();
				System.out.println("新增訂單:按 1  (按-1 離開, 按8 查看庫存)");
				System.out.print("> ");
				input = sc.nextInt();
				if (input == 1) {
					System.out.println("已創建新單");
					System.out.println();
				}

				//查看庫存
			} else if (input == 8) {
				System.out.println(Inventory.getDisplay());
				System.out.println("繼續> ");
				input = sc.nextInt();

				//結帳
			} else if (input == 9) {
				System.out.println("訂單明細:");
				System.out.println(order.getOrderDisplay());
				System.out.println();
				System.out.println("新單按1 , 查看庫存按8 , 離開程式按-1");
				System.out.print("> ");
				order = new Order();
				input = sc.nextInt();
				if (input == 1) {
					System.out.println("已創建新單");
				}

				//exit 
			} else if (input == -1) {
				break;

				//指令瞎按
			} else {
				System.out.print("> ");
				input = sc.nextInt();
			}

		}

	}

}
