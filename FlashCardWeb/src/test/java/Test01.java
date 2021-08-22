import org.junit.Test;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run(12123);
		run(76644);
		run(65456);
	}

	static int compute(int input, int state) {
		int r = (input % 10) ^ state;
		System.out.printf("%d - %d -> %d\n", input, state, r);
		return r;
	}

	static int run(int input) {
		return compute(input / 10000,
				compute(input / 1000, compute(input / 100, compute(input / 10, compute(input, 0)))));
	}
	
	@Test
	public void test() {
		System.out.println(10^2);
	}

}
