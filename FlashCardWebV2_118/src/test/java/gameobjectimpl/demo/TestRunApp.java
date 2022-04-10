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

		//person.addFunctionComponent(new TestGameController());
		person.addScript(new TestGameController() );

		/**
		 * game config
		 * animator 於 bean config xml 
		 */
		{
			TestGameController gc = new TestGameController();
			person.getAnimatorControl().setCurrentAnimatorId("idle");
			
			gc.setPerson(person);

		}

		Scene.run(frame.getGameObjectPanel());

	}

}
