package gameobjectimpl.control;

import gameobjectimpl.component.GameObject;

public interface ScriptI {

	public void setOwner(GameObject owner);

	public GameObject getOwner();
	
	public void execute();
}
