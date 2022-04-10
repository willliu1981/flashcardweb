package gameobjectimpl.control;

import gameobjectimpl.component.GameObject;

public abstract class GameController implements GameControllerI {

	private GameObject owner;

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
	
	

}
