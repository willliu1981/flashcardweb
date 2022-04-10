package gameobjectimpl.component.impl;

import java.util.List;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.animator.AnimatorBuilder;
import gameobjectimpl.animator.AnimatorResolver;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.HasAnimation;
import gameobjectimpl.component.IsAnimatorGameObjectBean;
import gameobjectimpl.component.Script;
import idv.fc.exception.FindErrorException;
import idv.tool.Debug;

public class Person extends GameObject
		implements HasAnimation, IsAnimatorGameObjectBean ,HasScript {

	protected String animatorBuilder;
	protected AnimatorResolver animatorResolver;

	public Person() {

	}

	@Override
	public String toString() {
		return "Person [animatorBuilder=" + animatorBuilder + ", animatorResolver="
				+ animatorResolver + ", toString()=" + super.toString() + "]";
	}

	@Override
	public void initAnimators() {
		try {
			this.setAnimators(this.animatorResolver.getAnimators(animatorBuilder));


		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void setAnimatorBuilder(String animatorBuilder) {
		this.animatorBuilder = animatorBuilder;
	}

	@Override
	public void setAnimatorResolver(AnimatorResolver animatorResolver) {
		this.animatorResolver = animatorResolver;
	}





}
