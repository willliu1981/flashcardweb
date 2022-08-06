package test3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import idv.test.TestLog;

public class Test5 extends TestLog {

//	private static final String json1 = "-abcc-x-abc-";
	private static final String json1 = "[abcc,xyz],[x],[abc]";

	public static void main(String[] args) {
		System.out.println("json1: "+json1);
		System.out.println("");


		String find = find(json1, "\\[.+?\\]");
		System.out.println("result: " + find);
	}

	static String find(String json, String key) {
		System.out.println("finding...");
		Pattern p = Pattern.compile(key);
		Matcher m = p.matcher(json);

		int start = 0;
		int end = 0;

		String result = null;

		while (m.find()) {
			String group = m.group();
			System.out.println("group: " + group);
			start = m.start();
			end = m.end();
			System.out.println("find start: " + start);
			System.out.println("find end: " + end);
			System.out.println("find by substring: " + (result = json.substring(start, end)));
			System.out.println("");

		}
		
		return result;
	}
}
