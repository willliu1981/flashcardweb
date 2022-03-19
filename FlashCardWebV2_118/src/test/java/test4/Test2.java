package test4;

import java.util.HashMap;
import java.util.Map;

import idv.fc.model.User;
import idv.tool.Debug;

public class Test2 {

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		 map.put("xx", null);

		 String ss=(String) map.get("xx");
		 
		Debug.test(ss);
	}

}
