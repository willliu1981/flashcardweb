package gameobjectimpl.demo;

import gameobjectimpl.component.Scene;
import gameobjectimpl.component.impl.Person;
import gameobjectimpl.config.Application;
import gameobjectimpl.control.TestGameController;
import gameobjectimpl.gui.RunGameObjectFrame;

public class TestRunApp {

	public static void main(String[] args) throws InterruptedException {
		RunGameObjectFrame frame = new RunGameObjectFrame();
		frame.setVisible(true);

		Person person = Application.getBean("person1", Person.class);
		Scene.addSceneComponent(person);

		//game contorller config
		{
			TestGameController gc = new TestGameController();
			Scene.addGameControllerI(gc);
			gc.setPerson(person);

		}

		Scene.run(frame.getGameObjectPanel());

	}

}
