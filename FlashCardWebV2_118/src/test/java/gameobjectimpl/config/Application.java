package gameobjectimpl.config;

import java.awt.Point;

import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.impl.Person;
import idv.tool.spring.MySpringUtil;

public class Application {

	public static Point getScreenSize() {
		return new Point(1900, 1000);
	}

	public static <T> T getBean(String name, Class<T> clazz) {
		String[] paths = {
				"classpath:gameobjectimpl/config/person1-component-mapping.xml" };

		return MySpringUtil.setApplicationContext(paths).getBean(name, clazz);
	}

}
