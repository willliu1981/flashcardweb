package gameobjectimpl.component.impl;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.component.GameObject;

public class Person extends GameObject {
	private Animator animator;

	public Animator getAnimator() {
		return animator;
	}

	public void setAnimator(Animator animator) {
		animator = animator;
	}

}
