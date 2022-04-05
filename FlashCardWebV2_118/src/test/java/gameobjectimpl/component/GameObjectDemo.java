package gameobjectimpl.component;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.component.impl.Person;
import gameobjectimpl.config.Application;
import gameobjectimpl.gui.GameObjectFrame;
import gameobjectimpl.gui.PersonCreatorFrame;
import gameobjectimpl.tool.Animators;
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

		Person person = Application.getBean("David", Person.class);
		sc.addSceneComponent(person);
		person.addAnimator("walk", Animators.load("David"));
		Animators.setPosture(person, 0);
		sc.locating();

		PersonCreatorFrame pcf = new PersonCreatorFrame(person);
		pcf.setVisible(true);

		//Animator animator = Animators.load("David");

		//Debug.test(animator);

		// Scene.run(frame.getGameObjectPanel());
	}

}
