package test;

public class Test3 {

	public static void main(String[] args) {

		int max = 5;

		for (int i = 1, d = -1; i != 0; i += d) {
			for (int n = 1; n <= i; n++) {
				System.out.print("*");
			}
			System.out.println();
			if (i == max || i == 1) {
				d = -1 * d;
			}
		}

	}

}
