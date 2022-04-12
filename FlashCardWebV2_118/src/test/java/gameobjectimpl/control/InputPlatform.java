package gameobjectimpl.control;

import java.awt.Point;
import java.util.Date;

import gameobjectimpl.animator.AnimatorControl;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.impl.Person;
import idv.tool.Debug;

public class InputPlatform extends GameController {
	Point screenSize;
	GameObject target;
	AnimatorControl animatorControl;
	int dir = 0;
	long beginTime;

	public InputPlatform(Point screenSize) {
		this.screenSize = screenSize;
	}

	static enum AniType {
		IDLE("idle"), WALK_RIGHT("walk-right"), WALK_LEFT("walk-left");

		String value;

		AniType(String name) {
			value = name;
		}

		public String getValue() {
			return this.value;
		}
	}

	public void setAnimatorControl(AnimatorControl animatorControl) {
		this.animatorControl = animatorControl;
	}

	public void setTarget(GameObject person) {
		this.target = person;
	}

	@Override
	public void start() {
		this.beginTime = new Date().getTime();
	}

	@Override
	public void update() {
		
		switch (animatorControl.getCurrentAnimatorId()) {

		case "idle":

			break;
		case "walk-right":
			this.target.setX(this.target.getX() + 15);
			break;
		case "walk-left":
			this.target.setX(this.target.getX() - 15);
			break;

		default:
			

			break;
		}

		//	Debug.test("ip",this.target.getX());

	}

}
