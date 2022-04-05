package gameobjectimpl.demo;

import gameobjectimpl.component.Scene;
import gameobjectimpl.component.impl.Person;
import gameobjectimpl.config.Application;
import gameobjectimpl.gui.GameObjectFrame;
import gameobjectimpl.tool.Animators;

public class TestRunApp {

	public static void main(String[] args) throws InterruptedException {

		//*
		GameObjectFrame frame = new GameObjectFrame();
		frame.setVisible(true);
		//*/

		Person person = Application.getBean("David", Person.class);
		Scene.addSceneComponent(person);
		person.addAnimator("walk", Animators.load("David"));
		Animators.setPosture(person, 0);
		Scene.locating();

		Scene.run(frame.getGameObjectPanel());
	}

}
