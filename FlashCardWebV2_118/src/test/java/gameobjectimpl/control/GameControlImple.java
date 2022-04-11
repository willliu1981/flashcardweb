package gameobjectimpl.control;

import gameobjectimpl.component.GameObject;

public abstract class GameControlImple implements GameControlI {

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
		return "GameController [owner=" + owner + "]";
	}

	@Override
	public boolean isStarted() {
		if (!this.isStarted) {
			this.isStarted = true;
			return false;
		}
		return true;
	}

}
