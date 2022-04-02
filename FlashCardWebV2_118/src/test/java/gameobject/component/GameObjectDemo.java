package gameobject.component;

import gameobject.component.impl.Person;
import gameobject.config.Application;
import gameobject.gui.GameObjectFrame;
import gameobject.gui.PersonCreatorFrame;
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
		GameObject person = Application.getPerson();
		sc.addSceneComponent(person);
		
		PersonCreatorFrame pcf=new PersonCreatorFrame();
		pcf.setTarget(person);
		pcf.setVisible(true);
		

		//Scene.run(frame.getGameObjectPanel());
	}

}
