package gameobject.control;

import java.awt.Point;
import java.util.List;

import gameobject.component.Component;
import gameobject.component.Scene;
import idv.tool.Debug;

public class GameControler {

	public static void move() {
		List<Component> gameObjects = Scene.getSceneComponent();
		gameObjects.forEach(go -> {
			Point p = go.getRelevantPosition();
			p.x = p.x + 10;
			go.setRelevantPosition(p);
		});

	}

}
