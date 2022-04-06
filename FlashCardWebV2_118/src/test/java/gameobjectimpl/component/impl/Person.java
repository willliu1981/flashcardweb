package gameobjectimpl.component.impl;

import gameobjectimpl.animator.AnimatorBuilder;
import gameobjectimpl.animator.AnimatorResolver;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.HasAnimation;
import gameobjectimpl.component.IsAnimatorGameObjectBean;
import idv.fc.exception.FindErrorException;
import idv.tool.Debug;

public class Person extends GameObject
		implements HasAnimation, IsAnimatorGameObjectBean {
	protected AnimatorBuilder animatorBuilder;
	protected String animatorBuilderBean;
	protected AnimatorResolver animatorResolver;

	public Person() {

	}

	@Override
	public void setAnimatorBuilder(AnimatorBuilder animatorBuilder) {
		this.animatorBuilder = animatorBuilder;
	}

	@Override
	public String toString() {
		return "Person [animator=" + this.getAnimators() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public void initAnimators() {
		try {
			//this.setAnimators(animatorBuilder.getAnimators());

			this.setAnimators(this.animatorResolver.getAnimators(animatorBuilderBean));
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void setAnimatorResolver(AnimatorResolver animatorResolver) {
		this.animatorResolver = animatorResolver;

	}

	@Override
	public void setAnimatorBuilder(String builderBean) {
		this.animatorBuilderBean = builderBean;
	}
}
