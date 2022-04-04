package gameobjectimpl.component.impl;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.HasAnimation;

public class Person extends GameObject  implements  HasAnimation{
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
