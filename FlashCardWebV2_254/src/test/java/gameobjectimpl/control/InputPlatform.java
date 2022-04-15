package gameobjectimpl.control;

import java.awt.Point;

import gameobjectimpl.component.GameObject;

public abstract class InputPlatform extends GameControllerAdapter {

	GameObject target;
	int dir = 0;

	public void setTarget(GameObject person) {
		this.target = person;
	}

	public void setDirection(int dir) {
		if (dir > 0) {
			this.dir = 1;
		} else if (dir < 0) {
			this.dir = -1;
		} else {
			this.dir = 0;
		}
	}

}
