package gameobjectimpl.component;

import java.util.List;

import gameobjectimpl.animator.Animator;

public interface HasAnimation {

	public void addAnimator(String name, Animator animator);

	public Animator getAnimator(String name);
	
	public List<Animator> getAnimators();

	public void initAnimators();
}
