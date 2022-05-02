package idv.psi.main;

import java.util.Scanner;

import idv.psi.model.Inventory;
import idv.psi.model.Product;
import idv.psi.service.Client;

public class Demo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//init start
		Inventory.initialize(10);

		Product p1 = new Product("沙朗牛排", "嚴選最頂級澳洲和牛", 400);
		Product p2 = new Product("松阪豬", "整頭豬最珍貴的地方", 320);
		Product p3 = new Product("脆皮雞排", "外皮煎的香酥脆口，肉汁鮮美不乾硬", 260);
		Inventory.setProduct(0, p1);
		Inventory.setProduct(1, p2);
		Inventory.setProduct(2, p3);

		//init end

		System.out.println(Inventory.display());

		Client clt = new Client();

		clt.addOrder(null);

		System.out.println("新增訂單:按1");

		/*while (true) {
		
			if (sc.nextInt() == 1) {
				System.out.println("選擇產品:1~10");
		
			}
		
		}*/

	}

}
