package test4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2_2 {

	private static Map<String, Integer> sortOrder = new HashMap<String, Integer>();
	private final static int MAX_SORT_ORDER = 4;

	private static int getSortOrder(String inputStr) {
		int result = MAX_SORT_ORDER;
		Integer IntegerValue = sortOrder.get(inputStr);
		if (IntegerValue == null) {
			return result;
		} else {
			return IntegerValue;
		}
	}

	public static void main(String[] args) {
		sortOrder.put("red", 1);
		sortOrder.put("green", 2);
		sortOrder.put("orange", 3);

		// String[] colors = {"blue", "red", "green", "yellow", "orange"};
		String[] colors = { "blue", "green", "yellow", "orange", "red" };
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
				int i1 = getSortOrder(o1);
				int i2 = getSortOrder(o2);
				return i1 - i2;
			}
		});
		// System.out.println("resultList");
		// System.out.println(resultList);

		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < 3; i++) {
			stringBuffer.append(resultList.get(i));
			stringBuffer.append("/");
		}
		a = stringBuffer.toString();
		System.out.println(a);
		System.out.println("hsiang-yu code-3");
	}
}