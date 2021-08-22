package test1;

import java.io.IOException;

public class Test implements ITest {

	@Override
	public void test() throws IOException{
		System.out.println("rrr");
		throw new IOException("ccc");
	}
	
	@org.junit.Test
	public void jtest() {
		try {
			test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
