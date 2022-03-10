package idv.fc.tool;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class Debug {

	public static void test(Object o, Object msg) {
		if (msg instanceof Map) {
			Map map = (Map) msg;
			System.out.println(o.getClass() + ":foreach...");
			map.forEach((k, v) -> System.out.printf("key=%s , value=%s\n", k, v));
		} else if (msg.getClass().isArray()) {
			System.out.println(o.getClass() + ":foreach...");
			Object[] os = (Object[]) msg;
			Arrays.asList(os).forEach(System.out::println);
		} else if (msg instanceof String) {
			System.out.println(o.getClass() + ":" + msg);
		} else {
			System.out.println(o.getClass() + ":" + msg);
		}
	}
}
