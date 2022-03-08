package test2;

import java.util.HashMap;
import java.util.Map;

public class Test2 {

	public static void main(String[] args) {
		Map<String, String> keys = new HashMap<>();
		model(keys);

		keys.forEach((x, y) -> System.out.println(x + "," + y));

	}

	public static void model(Map<String, String> keys) {
		keys.put("a", "A");
		keys.put("b", "B");
		keys.put("c", "C");
		keys.put("d", "D");
	}

}
