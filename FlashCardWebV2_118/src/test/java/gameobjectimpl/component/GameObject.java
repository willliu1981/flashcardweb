package gameobjectimpl.component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.animator.AnimatorControl;

public class GameObject extends Component {
	//private Map<String, Animator> animators;

	private AnimatorControl animatorControl;

	public GameObject() {

	}

	public AnimatorControl getAnimatorControl() {
		if (this.animatorControl == null) {
			this.animatorControl = new AnimatorControl();
			this.animatorControl.setOwner(this);
		}
		return animatorControl;
	}

	public Animator getAnimator(String name) {
		return this.getAnimatorControl().getAnimator(name);
	}

	public final void setAnimators(Map<String, Animator> animators) {
		this.getAnimatorControl().setAnimators(animators);

	}

	public Map<String, Animator> getAnimators() {

		return this.getAnimatorControl().getAnimators();
	}

	public List<Animator> getToListAnimators() {
		return this.getAnimatorControl().getAnimators().values().stream()
				.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "GameObject [animatorControl=" + animatorControl + "]";
	}

}
