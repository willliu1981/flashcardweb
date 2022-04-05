package gameobjectimpl.component;

import java.util.HashMap;
import java.util.Map;

import gameobjectimpl.animator.Animator;

public class GameObject extends Component {
	protected Map<String, Animator> animatorMap;

	public GameObject() {
		initAnimators();
	}

	public void addAnimator(String name, Animator animator) {
		this.animatorMap.put(name, animator);
	}

	public Animator getAnimator(String name) {
		return this.animatorMap.get(name);
	}

	public void initAnimators() {

	}
}
