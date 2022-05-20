package test3;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import idv.debug.Debug;
import idv.test.TestLog;

public class Test1 extends TestLog {

	@Test
	public void test1() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");

		Debug.test(new Object() {
		}, "list", list);
	}
}
