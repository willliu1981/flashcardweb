package test3;

import idv.fc.tool.Debug;

public class Test4 {

	public static void main(String[] args) {

		A a = new A();
		Debug.test(null, a.getAAA());

	}

	static class A {
		private String aaa = "a";

		A() {
			aaa += "x";
		}

		String getAAA() {
			return aaa;
		}

	}

}
