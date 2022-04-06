package gameobjectimpl.component;

import gameobjectimpl.animator.AnimatorBuilder;
import gameobjectimpl.animator.AnimatorResolver;

public interface IsAnimatorGameObjectBean {
	public void setAnimatorBuilder(AnimatorBuilder animatorBuilder);
	public void setAnimatorBuilder(String builderBean);
	public void setAnimatorResolver(AnimatorResolver animatorResolver);

	public void initAnimators();
}
