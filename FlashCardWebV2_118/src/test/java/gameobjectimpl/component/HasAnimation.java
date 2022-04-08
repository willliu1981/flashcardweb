package gameobjectimpl.component;

import java.util.List;
import java.util.Map;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.animator.AnimatorControl;

public interface HasAnimation {

	public Animator getAnimator(String name);

	public List<Animator> getToListAnimators();

	public Map<String, Animator> getAnimators();

	public void addAnimator(String name, Animator anm);

	public void initAnimators();

}
