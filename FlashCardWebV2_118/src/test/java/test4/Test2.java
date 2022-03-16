package test4;

import java.util.HashMap;
import java.util.Map;

import idv.fc.model.User;
import idv.fc.tool.Debug;

public class Test2 {

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();

		try {
			Debug.test("xxx");
			throw new Exception("xxx");

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
