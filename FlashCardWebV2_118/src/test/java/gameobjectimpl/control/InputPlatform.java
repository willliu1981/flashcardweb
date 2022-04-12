package gameobjectimpl.control;

import java.awt.Point;
import java.util.Date;

import gameobjectimpl.animator.AnimatorControl;
import gameobjectimpl.component.impl.Person;
import idv.tool.Debug;

public class InputPlatform extends GameController {
	Point screenSize;
	Person person;
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

	@Override
	public void start() {
		this.person = (Person) this.getOwner();
		this.animatorControl = this.person.getAnimatorControl();
		this.beginTime = new Date().getTime();
	}

	@Override
	public void update() {
		//Debug.test(this.beginTime);

		switch (animatorControl.getCurrentAnimatorId()) {

		case "idle":

			break;
		case "walk-right":
			this.person.setX(this.person.getX() + 5);
			break;
		case "walk-left":
			this.person.setX(this.person.getX() - 5);
			break;

		default:
			break;
		}

	}

}
