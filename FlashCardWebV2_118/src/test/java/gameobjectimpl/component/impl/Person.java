package gameobjectimpl.component.impl;

import gameobjectimpl.Animator;
import gameobjectimpl.component.GameObject;

public class Person extends GameObject {
	private Animator Animator;

	public Animator getAnimator() {
		return Animator;
	}

	public void setAnimator(Animator animator) {
		Animator = animator;
	}

}
