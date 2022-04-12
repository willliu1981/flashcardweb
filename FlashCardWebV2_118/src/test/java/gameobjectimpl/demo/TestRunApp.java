package gameobjectimpl.demo;

import java.awt.Point;

import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.Scene;
import gameobjectimpl.component.impl.Person;
import gameobjectimpl.config.Application;
import gameobjectimpl.control.InputPlatform;
import gameobjectimpl.control.TestGameController;
import gameobjectimpl.gui.RunGameObjectFrame;

public class TestRunApp {

	public static void main(String[] args) throws InterruptedException {
		RunGameObjectFrame frame = new RunGameObjectFrame();
		frame.setVisible(true);

		Person person = Application.getBean("person1", Person.class);
		GameObject david = new GameObject();
		david.addComponent(person);
		david.setRelevantPosition(new Point(300, 200));
		//david.setOwner("David");

		//Scene.addSceneComponent(person);
		Scene.addSceneComponent(david);

		InputPlatform inputPlatform = new InputPlatform(new Point(1900, 1000));
		inputPlatform.setTarget(david
		inputPlatform.setAnimatorControl(person.getAnimatorControl());

		person.addScript(new TestGameController());
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
