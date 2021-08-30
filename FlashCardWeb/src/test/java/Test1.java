import java.util.Date;

import org.junit.Test;

public class Test1 {
	
	public enum EE{
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d;
		
		Enum<?> e;
		
		Test1 t=new Test1();
		System.out.println(t.toString());
	}
	
	@Test
	public void test() {
		String ss="3:2";
		
		String[] sss=ss.split(":");
		System.out.println(sss.length);
		System.out.println(sss[0]);
		System.out.println(sss[1]);
	}

}
