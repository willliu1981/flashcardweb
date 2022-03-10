package idv.fc.tool;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Debug {

	public static void test(Object o, Object msg) {
		if (msg instanceof Map) {
			Map<?, ?> map = (Map<?, ?>) msg;
			System.out.println(o + ": foreach...");
			map.forEach((k, v) -> System.out.printf("key=%s , value=%s\n", k, v));

		} else if (msg instanceof List) {
			List<?> list = (List<?>) msg;
			System.out.println(o + ": foreach...");
			list.forEach((x) -> System.out.printf("key=%s\n", x));

		} else if (msg.getClass().isArray()) {
			System.out.println(o + ": foreach...");
			Object[] os = (Object[]) msg;
			Arrays.asList(os).forEach(System.out::println);

		} else if (msg instanceof String) {
			System.out.println(o + ": " + msg);

		} else {
			System.out.println(o + ": " + msg);
		}
	}

}
