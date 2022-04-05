package gameobjectimpl.component;

import gameobjectimpl.animator.AnimatorBuilder;

public interface IsAnimatorGameObjectBean {
	public void setAnimatorBuilder(AnimatorBuilder animatorBuilder);

	public void initAnimators();
}
