package idv.fc.tool;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Debug {

	public static void test(Object msg) {
		test(null, msg);
	}

	public static void test(Object o, Object msg) {
		String objStr = o == null ? "" : o.toString() + ": ";

		if (msg == null) {
			System.out.println(objStr + msg);
			return;
		}

		if (msg instanceof Map) {
			Map<?, ?> map = (Map<?, ?>) msg;
			System.out.println(objStr + "foreach...");
			map.forEach((k, v) -> System.out.printf("key=%s , value=%s\n", k, v));

		} else if (msg instanceof List) {
			List<?> list = (List<?>) msg;
			System.out.println(objStr + "foreach...");
			list.forEach((x) -> System.out.printf("key=%s\n", x));

		} else if (msg.getClass().isArray()) {
			System.out.println(objStr + "foreach...");
			Object[] os = (Object[]) msg;
			Arrays.asList(os).forEach(System.out::println);

		} else if (msg instanceof String) {
			System.out.println(objStr + msg);

		} else {
			System.out.println(objStr + msg);
		}
	}

}
