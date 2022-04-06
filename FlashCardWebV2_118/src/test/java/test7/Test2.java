package test7;

import idv.tool.Debug;
import idv.tool.spring.MySpringUtil;

public class Test2 {

	public static void main(String[] args) {
		Car bean = MySpringUtil.setApplicationContext("classpath:test7/test.xml")
				.getBean("car", Car.class);

		Debug.test("main", bean.getName());
		bean.getComponents().forEach((k, v) -> System.out.println(k + "  :: " + v));
	}

}
