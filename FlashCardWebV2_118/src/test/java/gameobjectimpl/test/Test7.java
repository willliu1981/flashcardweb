package gameobjectimpl.test;

import idv.tool.Debug;
import idv.tool.spring.MySpringUtil;


public class Test7 {
	

	
	public static void main(String[] args) {
		String[] paths = {
				"classpath:gameobjectimpl/config/person1-component-mapping.xml",
				"classpath:gameobjectimpl/config/animator.xml" };

		//*
		Car bean = MySpringUtil.setApplicationContext(paths).getBean("car1", Car.class);
		//*/

		/*		
		Car bean = MySpringUtil
				.setApplicationContext("classpath:gameobjectimpl/config/animator.xml")
				.getBean("car1", Car.class);
		//*/

		Debug.test("main", bean.getName());
		bean.getComponents().forEach((k, v) -> System.out.println(k + "  :: " + v));
	}

}
