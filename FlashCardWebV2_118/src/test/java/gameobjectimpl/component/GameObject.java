package gameobjectimpl.component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.animator.AnimatorBuilder;

public class GameObject extends Component {
	private Map<String, Animator> animators;

	public GameObject() {

	}

	public void addAnimator(String name, Animator animator) {
		if (this.animators == null) {
			this.animators = new HashMap<>();
		}
		this.animators.put(name, animator);
		animator.setOwner(this);
	}

	public Animator getAnimator(String name) {
		return this.animators.get(name);
	}

	public List<Animator> getAnimators() {
		return this.animators.values().stream().collect(Collectors.toList());
	}

	public final void setAnimators(Map<String, Animator> animators) {
		animators.forEach((k, v) -> {
			addAnimator(k, v);
		});

	}
}
