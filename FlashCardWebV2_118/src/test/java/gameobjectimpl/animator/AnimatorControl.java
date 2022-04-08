package gameobjectimpl.animator;

import java.util.Map;

import gameobjectimpl.component.GameObject;

public class AnimatorControl {
	private GameObject owner;

	private Map<String, Animator> animators;

	public GameObject getOwner() {
		return owner;
	}

	public void setOwner(GameObject owner) {
		this.owner = owner;
	}

	public Map<String, Animator> getAnimators() {
		return animators;
	}

	public void setAnimators(Map<String, Animator> animators) {
		this.animators = animators;
	}
	
	public void addAnimator(String name, Animator anm) {
		this.animators.put(name, anm);
	}

	public Animator getAnimator(String name) {
		return this.animators.get(name);
	}

	@Override
	public String toString() {
		return "AnimatorControl [owner=" + owner.getName() + ", animators=" + animators
				+ "]";
	}

}
