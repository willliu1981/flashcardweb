package gameobjectimpl.demo;

import gameobjectimpl.animator.AnimatorResolver;
import gameobjectimpl.component.Scene;
import gameobjectimpl.component.impl.Person;
import gameobjectimpl.config.Application;
import gameobjectimpl.gui.GameObjectFrame;
import gameobjectimpl.tool.Animators;
import idv.tool.Debug;
import idv.tool.spring.MySpringUtil;

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
		GameObjectFrame frame = new GameObjectFrame();
		frame.setVisible(true);

		Person person = Application.getBean("David", Person.class);
		Scene.addSceneComponent(person);
		//Animators.setPosture(person, 0);
		//Scene.locating();

		Scene.run(frame.getGameObjectPanel());

		//*/
	}

}
