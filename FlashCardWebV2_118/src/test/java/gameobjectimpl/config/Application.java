package gameobjectimpl.config;

import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.impl.Person;
import idv.tool.spring.MySpringUtil;

public class Application {

	public static GameObject getPerson() {
		return MySpringUtil
				.setApplicationContext("classpath:gameobject/config/game-config.xml")
				.getBean("person1", Person.class);
	}
	
	

}
