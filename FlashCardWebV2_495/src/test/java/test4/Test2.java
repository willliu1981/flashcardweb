package test4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		String[] colors = { "blue", "red", "green", "yellow", "orange" };
		String a = "";
		List<String> resultList = new ArrayList<String>();
		for (int i = 0, len = colors.length; i < len; i++) {
			resultList.add(colors[i]);
		}

		resultList.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				/* 指定排序順序必須是：red、green、orange */
				/* 如果 o1 順序 必須小於 o2 回傳 -1 */
				/* 如果 o1 順序 o2 順序相等 回傳 0 */
				/* 如果 o1 順序 必須大於 o2 回傳 1 */
				if (o1.equals("red") && o2.equals("green")) {
					return -1;
				} else if (o1.equals("red") && o2.equals("orange")) {
					return -1;
				} else if (o1.equals("green") && o2.equals("orange")) {
					return -1;
				} else if (o1.equals("green") && o2.equals("red")) {
					return 1;
				} else if (o1.equals("orange") && o2.equals("red")) {
					return 1;
				} else if (o1.equals("orange") && o2.equals("green")) {
					return 1;
				} else if (o1.equals(o2)) {
					return 0;
				} else if (o1.equals("red") || o1.equals("green")
						|| o1.equals("orange")) {
					/* red、green、orange 必須排列最前面 */
					return -1;
				}
				return 0;
			}
		});

		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < 3; i++) {
			stringBuffer.append(resultList.get(i));
			stringBuffer.append("/");
		}
		a = stringBuffer.toString();
		System.out.println(a);
	}
}
