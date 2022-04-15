package gameobjectimpl.control;

import gameobjectimpl.component.GameObject;

public abstract class GameControllerAdapter implements GameControlI {

	private GameObject owner;
	private boolean isStarted = false;

	@Override
	public void setOwner(GameObject owner) {
		this.owner = owner;

	}

	@Override
	public GameObject getOwner() {
		return this.owner;
	}

	@Override
	public String toString() {
		return "GameController [owner=" + owner.getName() + "]";
	}

	@Override
	public boolean isStarted() {
		if (!this.isStarted) {
			this.isStarted = true;
			return false;
		}
		return true;
	}

	@Override
	public void init() {

	}

}
