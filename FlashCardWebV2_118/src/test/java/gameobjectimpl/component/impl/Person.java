package gameobjectimpl.component.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.HasAnimation;

public class Person extends GameObject implements HasAnimation {

	@Override
	public String toString() {
		return "Person [animator=" + animators + ", toString()=" + super.toString()
				+ "]";
	}

	public void setAddAnimators(Map<String, Animator> animatorMap) {
		this.animators = animatorMap;
	}

	@Override
	public void initAnimators() {
		this.animators = new HashMap<>();

	}



}
