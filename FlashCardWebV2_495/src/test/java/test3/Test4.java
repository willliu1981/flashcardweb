package test3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import idv.test.TestLog;

public class Test4 extends TestLog {
	//註解40、41、42行, 取得3個array data
	//第15行, 測試非array data 

	private static final String json1 = "{\r\n"
			+ "  \"name\": \"new_table_test_table2_comcom\",\r\n"
			+ "  \"comment\": \"new_table_test_table2\",\r\n" 
			+ "  \"test\": \"Is array?\",\r\n"
			+ "  \"test3\": [\r\n"
			+ "  \"abc\",\r\n" 
			+ "  \"def\" \r\n"
			+ "  ],\r\n"
			+ "  \"dept\": \"New Table Test2\",\r\n" 
			+ "  \"projectName\": \"New Table Test2\",\r\n"
			+ "  \"reason\": \"New Table Test2\",\r\n" 
			+ "  \"test\": [\r\n"
			+ "  \"940aaa82611d\",\r\n" 
			+ "  \"1f099911e53b\",\r\n"
			+ "  \"1d184f114095\",\r\n" 
			+ "  \"372a488d2ed6\"\r\n"
			+ "  ],\r\n" 
			+ "  \"test2\": [\r\n" 
			+ "  \"123\",\r\n"
			+ "  \"456\" \r\n"
			+ "  ]\r\n" 
			+ "}";

	public static void main(String[] args) {
		System.out.println(json1);

		String json2 = json1.replace("\r\n", "");

		String find = findArrayData(json2, "\"test\"");
		//String find = find(json2, "\"test2\"");
		//String find = find(json2, "\"test3\"");
		
		System.out.println("result:" + find);
	}

	static String findArrayData(String json, String key) {
		Pattern p = Pattern.compile(key +"\\s*:\\s*\\[");
		Matcher m = p.matcher(json);

		int start = 0;
		int end = 0;

		String result = null;

		if (m.find()) {
			String group = m.group();
			System.out.println("group:" + group);
			start = m.start();
			end = m.end();
			System.out.println("start:" + start);
			System.out.println("end:" + end);
			System.out.println("substring:" + json.substring(start, end));
			System.out.println("");

			Pattern p2 = Pattern.compile(".+?\\]");
			m.usePattern(p2);
			if (m.find()) {
				String group2 = m.group();
				System.out.println("final group:" + group2);
				start = m.start();
				end = m.end();
				System.out.println("final start:" + start);
				System.out.println("final end:" + end);
				System.out.println("final substring:"
						+ (result = json.substring(start, end)));
				System.out.println("");
			}

		}
		return result;
	}

}
