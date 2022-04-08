package gameobjectimpl.demo;

import gameobjectimpl.component.Scene;
import gameobjectimpl.component.impl.Person;
import gameobjectimpl.config.Application;
import gameobjectimpl.control.TestGameController;
import gameobjectimpl.gui.RunGameObjectFrame;

public class TestRunApp {

	public static void main(String[] args) throws InterruptedException {
		/*
		String[] paths = {
				"classpath:gameobjectimpl/config/person1-component-mapping.xml",
				"classpath:gameobjectimpl/config/animator.xml" };
		AnimatorResolver bean = MySpringUtil
				.setApplicationContext(paths)
				.getBean("animatorResolver", AnimatorResolver.class);
		Debug.test(bean);
		//*/

		//*
		RunGameObjectFrame frame = new RunGameObjectFrame();
		frame.setVisible(true);

		Person person = Application.getBean("person1", Person.class);
		Scene.addSceneComponent(person);
		//Animators.setPosture(person, 0);
		//Scene.locating();
		Scene.addGameControllerI(new TestGameController());
		Scene.run(frame.getGameObjectPanel());

		//*/
	}

}
