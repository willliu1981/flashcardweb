package gameobjectimpl.config;

import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.impl.Person;
import idv.tool.spring.MySpringUtil;

public class Application {

	public static GameObject getPerson() {
		String[] paths = { "classpath:gameobjectimpl/config/person1-component-mapping.xml",
				"gameobjectimpl/config/animator.xml" };

		return MySpringUtil.setApplicationContext(paths).getBean("person1",
				Person.class);
	}

}
