package gameobjectimpl.component.impl;

import java.util.HashMap;

import gameobjectimpl.animator.AnimatorBuilder;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.HasAnimation;
import gameobjectimpl.component.IsAnimatorGameObjectBean;

public class Person extends GameObject
		implements HasAnimation, IsAnimatorGameObjectBean {
	protected AnimatorBuilder animatorBuilder;

	@Override
	public void setAnimatorBuilder(AnimatorBuilder animatorBuilder) {
		this.animatorBuilder = animatorBuilder;
	}

	@Override
	public String toString() {
		return "Person [animator=" + animators + ", toString()=" + super.toString()
				+ "]";
	}

	@Override
	public void initAnimators() {
		this.animators = animatorBuilder.getAnimators();
	}
}
