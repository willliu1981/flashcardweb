package gameobjectimpl.component;

import gameobjectimpl.component.impl.Person;
import gameobjectimpl.config.Application;
import gameobjectimpl.gui.GameObjectFrame;
import gameobjectimpl.gui.PersonCreatorFrame;
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
