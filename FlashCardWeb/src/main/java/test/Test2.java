package test;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class Test2 {

	public void TMethod() {

	}

	@Test
	public void test() {

		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int m = sc.nextInt();
		int d = sc.nextInt();
		// int t = (y - 1) * 365 + (y - 1) / 100 + (y - 1) / 400;
		int t = (y - 1) * 365 + (y - 1) / 4 - (y - 1) / 100 + (y - 1) / 400;
		switch (m - 1) {
		case 12:
			t = t + 31;
		case 11:
			t = t + 30;
		case 10:
			t = t + 31;
		case 9:
			t = t + 30;
		case 8:
			t = t + 31;
		case 7:
			t = t + 31;
		case 6:
			t = t + 30;
		case 5:
			t = t + 31;
		case 4:
			t = t + 30;
		case 3:
			t = t + 31;
		case 2:
			int s = (y % 400 == 0) || (y % 4 == 0) && (y % 100 != 0) ? 29 : 28;
			t = t + s;
		case 1:
			t = t + 31;
		}
		t = t + d;
		System.out.println(y - 1911);
		System.out.println(m);
		System.out.println(d);
		switch (t % 7) {
		case 0:
			System.out.printf("星期日");
			break;
		case 1:
			System.out.printf("星期一");
			break;
		case 2:
			System.out.printf("星期二");
			break;
		case 3:
			System.out.printf("星期三");
			break;
		case 4:
			System.out.printf("星期四");
			break;
		case 5:
			System.out.printf("星期五");
			break;
		case 6:
			System.out.printf("星期六");
			break;

		}

	}

}
