package test1;

public class Test3 {

	static boolean a;
	static boolean b = false;
	static boolean c = true;
	static String msg = "xxx";
	int ss = 1;
	boolean b1;
	String m2;

	static {
		a = true;
	}

	Test3() {
		b1 = c;
		m2 = msg;
	}

	public static void main(String[] args) {

		Test3 t3 = new Test3();
		Test3 test3 = new Test3();
		Class c = String.class;
	}

}
