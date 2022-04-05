package gameobjectimpl.component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import gameobjectimpl.animator.Animator;

public class GameObject extends Component {
	protected Map<String, Animator> animators;

	public GameObject() {
		initAnimators();
	}

	public void addAnimator(String name, Animator animator) {
		this.animators.put(name, animator);
		animator.setOwner(this);
	}

	public Animator getAnimator(String name) {
		return this.animators.get(name);
	}

	public void initAnimators() {

	}

	public List<Animator> getAnimators() {
		return this.animators.values().stream().collect(Collectors.toList());
	}
}
