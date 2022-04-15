package gameobjectimpl.demo;

import java.awt.Point;

import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.GameObjectFactory;
import gameobjectimpl.component.Scene;
import gameobjectimpl.component.impl.Person;
import gameobjectimpl.config.Application;
import gameobjectimpl.control.InputPlatform;
import gameobjectimpl.control.InputPlatformImpl;
import gameobjectimpl.control.ScriptFactory;
import gameobjectimpl.control.TestGameController;
import gameobjectimpl.gui.RunGameObjectFrame;

public class TestRunApp {

	public static void main(String[] args) throws InterruptedException {
		RunGameObjectFrame frame = new RunGameObjectFrame();
		frame.setVisible(true);

		for(int i=0;i<2;i++) {
			createPerson("David");
			createPerson("Helen");
			createPerson("Peter");
			
		}
	

		Scene.run(frame.getGameObjectPanel());

	}

	public static void createPerson(String name) {

		Person person = Application.getBean("person1", Person.class);
		GameObject PersonGO = GameObjectFactory.createGameObject(name);
		PersonGO.addComponent(person);
		PersonGO.setRelevantPosition(new Point(0, 100));

		Scene.addSceneComponent(PersonGO);

		InputPlatformImpl inputPlatform = ScriptFactory.getInputPlatform(PersonGO,
				InputPlatformImpl.class);

		TestGameController testGameController = new TestGameController();

		testGameController.setInputPlatform(inputPlatform);
		testGameController.setTarget(PersonGO);
		testGameController.setScreenSize(Application.getScreenSize());

		person.addScript(testGameController);
		person.addScript(inputPlatform);
	}

}
