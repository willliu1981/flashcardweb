package gameobjectimpl.animator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import gameobjectimpl.component.GameObject;

public class AnimatorControl {
	private GameObject owner;
	private String currentAnimator;

	private Map<String, Animator> animators;
	private Map<String, Integer> currentKeyIndexes = new HashMap<>();

	public Integer getCurrentKeyIndex(String anmName) {
		return this.currentKeyIndexes.get(anmName);
	}

	public void setCurrentKeyIndex(String anmName, Integer index) {
		this.currentKeyIndexes.put(anmName, index);
	}

	public Animator getCurrentAnimator() {
		Optional<Animator> findFirst = getAnimators().values().stream()
				.filter(anm -> anm.getName().equals(currentAnimator)).findFirst();
		if (findFirst.isPresent()) {
			return findFirst.get();
		}

		return null;
	}

	public String getCurrentAnimatorId() {
		return currentAnimator;
	}

	public void setCurrentAnimatorId(String currentAnimator) {
		this.currentAnimator = currentAnimator;
		this.currentKeyIndexes.put(currentAnimator, 0);
	}

	public GameObject getOwner() {
		return owner;
	}

	public void setOwner(GameObject owner) {
		this.owner = owner;
	}

	public Map<String, Animator> getAnimators() {
		if (this.animators == null) {
			this.animators = new HashMap<>();
		}
		return animators;
	}

	public void setAnimators(Map<String, Animator> animators) {
		this.animators = animators;
	}

	public void addAnimator(String name, Animator anm) {
		getAnimators().put(name, anm);
	}

	public Animator getAnimator(String name) {

		return getAnimators().get(name);
	}

	@Override
	public String toString() {
		return "AnimatorControl [owner=" + owner.getName() + ", animators=" + animators
				+ "]";
	}

}
