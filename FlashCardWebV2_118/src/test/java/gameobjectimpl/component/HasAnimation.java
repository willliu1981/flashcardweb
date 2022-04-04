package gameobjectimpl.component;

import gameobjectimpl.animator.Animator;

public interface HasAnimation {
	public Animator getAnimator();

	public void setAnimator(Animator animator);
}
