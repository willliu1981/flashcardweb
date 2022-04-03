package gameobjectimpl.config;

import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.impl.Person;
import idv.tool.spring.MySpringUtil;

public class Application {

	public static<T> T getBean(String name,Class<T> clazz) {
		String[] paths = { "classpath:gameobjectimpl/config/person1-component-mapping.xml",
				"gameobjectimpl/config/animator.xml" };

		return MySpringUtil.setApplicationContext(paths).getBean(name,
				clazz);
	}

}
