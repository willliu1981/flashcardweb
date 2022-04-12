package gameobjectimpl.demo;

import java.awt.Point;

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
		Scene.addSceneComponent(person);

		//person.addFunctionComponent(new TestGameController());
		person.addScript(new TestGameController());
		person.addScript(new InputPlatform(new Point(1900, 1000)));

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
