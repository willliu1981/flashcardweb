package test.robot;

import java.awt.Point;

public class Scene extends GameObject {
	private static Component component=new Component();
	
	public Scene(){
		component.setName("scene");
		component.setAbsolute(new Point());
	}
	
	public Component getComponent() {
		return Scene.component;
	}

}
