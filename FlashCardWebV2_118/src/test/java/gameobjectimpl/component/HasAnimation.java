package gameobjectimpl.component;

import gameobjectimpl.animator.Animator;

public interface HasAnimation {

	public void addAnimator(String name, Animator animator);

	public Animator getAnimator(String name);

	public void initAnimators();
}
