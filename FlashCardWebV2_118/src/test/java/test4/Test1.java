package test4;

public class Test1 {

	static class Human {
		String name;
		int age = 1;
		static int totalCount = 0;

		Human() {
			super();
			name = "untitled";
			age = -1; // 使用-1來標記沒有被設定，否則會初始化為0，但人類有可能0歲
			totalCount++;
		}

		Human(String str) {
			this();
			this.setName(str);
		}

		Human(String str, int a) {
			this(str);
			this.age = a;
		}

		public void setName(String name) {
			this.name = name;
		}

		void printInfo() {
			System.out.println(name + " 年齡：" + age + " 目前總人數：" + totalCount);
		}

	}

	static class Taiwanese extends Human {
		String abbreviation = "untitled";

		Taiwanese() {
			super();
			abbreviation = "tw";
			// System.out.println("台灣人的縮寫:" + abbreviation);

		}

		Taiwanese(String name, int age) {
			super(name, age);
			int test = 1;

		}

	}

	static class Ilaner extends Taiwanese {
		static String staple = "三星蔥";

		Ilaner() {
			super();
			// System.out.println("宜蘭人的特產:" + staple);
		}

		Ilaner(String name, int age) {
			super(name, age);
			test("test");
		}

		static void test(String test) {
			String testString = test;
		}
	}

	public static void main(String[] args) {

		Ilaner tw = new Ilaner("David", 22);
		Ilaner tw2 = new Ilaner();

	}

}
