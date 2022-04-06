package gameobjectimpl.control;

import java.awt.Point;
import java.util.List;

import gameobjectimpl.component.Component;
import gameobjectimpl.component.Scene;
import idv.tool.Debug;

public class TestGameController implements GameControllerI {
	private static int dir = -1;

	public static void move() {
		List<Component> gameObjects = Scene.getSceneComponents();
		gameObjects.forEach(go -> {
			Point p = go.getRelevantPosition();

			switch (dir) {
			case 1:
				p.x = p.x + 25;
				break;
			case -1:
				p.x = p.x - 25;
				break;
			default:
				break;
			}

			if (p.x > 800) {
				dir = -1;
			} else if (p.x < 50) {
				dir = 1;
			}
			go.setRelevantPosition(p);
		});

	}

}
