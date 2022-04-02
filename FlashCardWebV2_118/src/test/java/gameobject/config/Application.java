package gameobject.config;

import gameobject.component.GameObject;
import gameobject.component.impl.Person;
import idv.tool.spring.MySpringUtil;

public class Application {

	public static GameObject getPerson() {
		return MySpringUtil
				.setApplicationContext("classpath:gameobject/config/game-config.xml")
				.getBean("person1", Person.class);
	}

}
