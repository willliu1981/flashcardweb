package gameobjectimpl.control;

import java.awt.Point;
import java.util.List;

import gameobjectimpl.component.Component;
import gameobjectimpl.component.Scene;
import idv.tool.Debug;

public class GameControler {

	public static void move() {
		List<Component> gameObjects = Scene.getSceneComponents();
		gameObjects.forEach(go -> {
			Point p = go.getRelevantPosition();
			p.x = p.x + 10;
			go.setRelevantPosition(p);
		});

	}

}
