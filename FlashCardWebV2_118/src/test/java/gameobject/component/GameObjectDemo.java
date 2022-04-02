package gameobject.component;

import gameobject.component.impl.Person;
import gameobject.config.Application;
import gameobject.gui.GameObjectFrame;
import gameobject.gui.PersonCreatorFrame;
import idv.tool.Debug;
import idv.tool.spring.MySpringUtil;

public class GameObjectDemo {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		Scene sc = new Scene();

		/*
		GameObjectFrame frame = new GameObjectFrame();
		GameObjectFrame.setScene(sc);
		frame.setVisible(true);
		//*/
		GameObject person = Application.getPerson();
		sc.addSceneComponent(person);
		sc.locating();

		PersonCreatorFrame pcf = new PersonCreatorFrame(person);
		pcf.setVisible(true);

		// Scene.run(frame.getGameObjectPanel());
	}

}
