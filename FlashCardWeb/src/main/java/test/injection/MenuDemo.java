package test.injection;

import java.util.Scanner;

import org.junit.Test;

import test.injection.MenuDocument.ControlType;

public class MenuDemo {

	public static void main(String[] s) {
		Scanner sc = new Scanner(System.in);

		int msg = 0;

		Menu menu = new Menu();
		MenuDocument doc = menu.getDoc();
		AttributeSet setChild = new AttributeSet();
		AttributeSet setAdult = new AttributeSet();
		AttributeSet setElderly = new AttributeSet();
		MenuComparators.setComparator(setChild, MenuComparators.TYPE_RANDOM,
				new String[] { "稀飯", "玉米脆片", "巧克力脆片" });
		MenuComparators.setName(setChild, "小孩子的");

		MenuComparators.setComparator(setAdult, MenuComparators.TYPE_RANDOM,
				new String[] { "燴飯", "蛋炒飯", "什錦麵", "牛肉湯麵", "排骨便當" });
		MenuComparators.setName(setAdult, "年輕人的");

		MenuComparators.setComparator(setElderly, MenuComparators.TYPE_RANDOM,
				new String[] { "玉米粥", "麥片" });
		MenuComparators.setName(setElderly, "老年人的");

		doc.setComparatorAttributes(ControlType.MIN_INFINITY, 17, setChild,
				false);
		doc.setComparatorAttributes(18, 64, setAdult, false);
		doc.setComparatorAttributes(ControlType.MAX_INFINITY, 65, setElderly,
				false);

		System.out.print("age?: ");
		while (sc.hasNextInt()) {
			msg = sc.nextInt();
			if (msg == 999) {
				break;
			}
			System.out.println();
			System.out.println(menu.createMenu(msg));

			System.out.println("age?: ");
		}
	}

}
