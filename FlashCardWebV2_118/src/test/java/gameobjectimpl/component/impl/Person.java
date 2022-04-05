package gameobjectimpl.component.impl;

import java.util.HashMap;
import java.util.Map;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.HasAnimation;

public class Person extends GameObject implements HasAnimation {
	private Animator animator;

	@Override
	public String toString() {
		return "Person [animator=" + animator + ", toString()=" + super.toString()
				+ "]";
	}

	public void setAddAnimators(Map<String, Animator> animatorMap) {
		this.animatorMap = animatorMap;
	}

	@Override
	public void initAnimators() {
		this.animatorMap = new HashMap<>();

	}

}
