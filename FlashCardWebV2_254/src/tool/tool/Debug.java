package tool;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Debug {
	private static String PREFIXSEPARATOR = " : ";
	public static final String BEFORE = "before";
	public static final String AFTER = "after";

	private static class NoParam {

	}

	public static void test() {
		System.out.println();
	}

	public static void test(Object msg) {
		test(null, new NoParam(), msg, false);
	}

	public static void test(Object objForClassInfo, Object msg) {
		test(objForClassInfo, new NoParam(), msg, false);
	}

	public static void test(String prefixString, Object prefixObj, Object msg) {
		test(null, String.format("%s(%s)", prefixString, prefixObj), msg, false);
	}

	public static void test(Object objForClassInfo, Object prefixObj, Object msg) {
		test(objForClassInfo, prefixObj, msg, false);
	}

	public static void test(Object objForClassInfo, Object prefix, Object msg,
			boolean any) {
		String head = objForClassInfo == null ? ""
				: objForClassInfo.toString() + " : ";

		String prefixString = "";
		if (prefix == null) {
			prefixString = "" + prefix + PREFIXSEPARATOR;
		} else if (prefix.getClass() == NoParam.class) {
			prefixString = "";
		} else {
			prefixString = prefix.toString() + PREFIXSEPARATOR;
		}

		head += prefixString;

		if (msg == null) {
			System.out.println(head + msg);
			return;
		}

		if (msg instanceof Map) {
			Map<?, ?> map = (Map<?, ?>) msg;
			System.out.println(head + "foreach<Map>...");
			//map.forEach((k, v) -> System.out.printf("  key= %s , value= %s\n", k, v));
			System.out.println(map);

		} else if (msg instanceof List) {
			List<?> list = (List<?>) msg;
			System.out.println(head + "foreach(List)...");
			list.forEach((x) -> System.out.printf("  %s\n", x));

		} else if (msg.getClass().isArray()) {
			System.out.println(head + "foreach(Array)...");
			Object[] os = (Object[]) msg;
			Arrays.asList(os).forEach((x) -> System.out.printf("  %s\n", x));

		} else if (msg instanceof String) {
			System.out.println(head + msg);

		} else {
			System.out.println(head + msg);
		}
	}

}
