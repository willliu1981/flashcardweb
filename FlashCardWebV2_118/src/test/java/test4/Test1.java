package test4;

public class Test1 {

	static class Human {
		String name;
		int age;
		static int totalCount = 0;

		Human() {
			name = "untitled";
			age = -1; // 使用-1來標記沒有被設定，否則會初始化為0，但人類有可能0歲
			totalCount++;
		}

		Human(String str) {
			this();
			this.name = str;
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
		String abbreviation = "tw";

		Taiwanese() {
			super();
			System.out.println("台灣人的縮寫:" + abbreviation);

		}

		Taiwanese(int population) {
			super();
			this.totalCount = population;
			System.out.println("台灣人的縮寫:" + abbreviation);
			System.out.println("重設台灣的人口數:" + totalCount);

		}

//		@Override
//		public void setName(String name) {
//			super.setName(name);
//		}
		
		
	}

	static class Ilaner extends Taiwanese {
		String staple = "三星蔥";

		Ilaner() {
			super(2000);
			System.out.println("宜蘭人的特產:" + staple);
		}

		Ilaner(String name) {
			super();
			this.setName(name);
		}
	} 

	public static void main(String[] args) {
		//Ilaner tw = new Ilaner("David");
		
		int i=0;
		++i;
		
		
	}

}
