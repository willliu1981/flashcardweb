package gameobjectimpl.control;

import java.awt.Point;
import java.util.List;

import gameobjectimpl.component.Component;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.Scene;
import gameobjectimpl.component.impl.Person;
import idv.tool.Debug;

public class TestGameController extends GameController  {
	private static int dir = -1;

	private Person person;

	@Override
	public void start() {
		Debug.test("start...");
		person.getAnimatorControl().setCurrentAnimatorId("idle");
	}

	@Override
	public void update() {
		//Debug.test("update...");
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public void setOwner(GameObject owner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GameObject getOwner() {
		// TODO Auto-generated method stub
		return null;
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
