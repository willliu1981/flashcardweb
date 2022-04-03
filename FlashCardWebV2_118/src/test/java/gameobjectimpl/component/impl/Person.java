package gameobjectimpl.component.impl;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.component.GameObject;

public class Person extends GameObject {
	private Animator animator;

	public Animator getAnimator() {
		return animator;
	}

	public void setAnimator(Animator animator) {
		this.animator = animator;
	}

	@Override
	public String toString() {
		return "Person [animator=" + animator + ", toString()=" + super.toString()
				+ "]";
	}

}
