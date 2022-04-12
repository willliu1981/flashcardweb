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

		Person person = Application.getBean("person1", Person.class);
		GameObject david = GameObjectFactory.createGameObject("David");
		david.addComponent(person);
		david.setRelevantPosition(new Point(0, 100));

		Scene.addSceneComponent(david);

		InputPlatformImpl inputPlatform = ScriptFactory.getInputPlatform(david,
				InputPlatformImpl.class);

		TestGameController testGameController = new TestGameController();

		testGameController.setInputPlatform(inputPlatform);
		testGameController.setTarget(david);
		testGameController.setScreenSize(Application.getScreenSize());

		person.addScript(testGameController);
		person.addScript(inputPlatform);

		/**
		 * game config
		 * animator 於 bean config xml 
		 */
		{
			TestGameController gc = new TestGameController();

		}

		Scene.run(frame.getGameObjectPanel());

	}

}
