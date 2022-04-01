package gameobject.component;

import gameobject.component.impl.Body;
import gameobject.component.impl.Person;
import gameobject.gui.GameObjectFrame;
import idv.tool.spring.MySpringUtil;

public class GameObjectDemo {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {

		Scene sc = new Scene();


		GameObjectFrame frame = new GameObjectFrame();
		GameObjectFrame.setScene(sc);
		frame.setVisible(true);

		sc.addSceneComponent(MySpringUtil
				.setApplicationContext("classpath:gameobject/config/game-config.xml")
				.getBean("person1", Person.class));

		Scene.run(frame.getGameObjectPanel());

	}

}
