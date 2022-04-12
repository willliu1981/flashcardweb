package gameobjectimpl.control;

import java.awt.Point;
import java.util.List;

import gameobjectimpl.component.Component;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.Scene;
import gameobjectimpl.component.impl.Person;
import idv.tool.Debug;

public class TestGameController extends GameController {
	private static int dir = -1;

	@Override
	public void start() {
		Debug.test("start...");
		this.getOwner().getAnimatorControl().setCurrentAnimatorId("walk-right");
	}

	@Override
	public void update() {
		//Debug.test("TGC",this.getOwner().getX());
		
		
		
	}

	//	public static void move() {
	//		List<Component> gameObjects = Scene.getSceneComponents();
	//		gameObjects.forEach(go -> {
	//			Point p = go.getRelevantPosition();
	//
	//			switch (dir) {
	//			case 1:
	//				p.x = p.x + 25;
	//				break;
	//			case -1:
	//				p.x = p.x - 25;
	//				break;
	//			default:
	//				break;
	//			}
	//
	//			if (p.x > 800) {
	//				dir = -1;
	//			} else if (p.x < 50) {
	//				dir = 1;
	//			}
	//			go.setRelevantPosition(p);
	//		});
	//
	//	}

}
