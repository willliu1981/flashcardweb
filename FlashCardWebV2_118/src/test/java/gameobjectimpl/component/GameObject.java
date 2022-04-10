package gameobjectimpl.component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.animator.AnimatorControl;

public class GameObject extends Component {
	//private List<FunctionComponent> functionComponents = new ArrayList<>();

	private AnimatorControl animatorControl;
	private List<Script> scripts;

	public GameObject() {

	}

	/*public void addFunctionComponent(FunctionComponent functionComponent) {
		this.functionComponents.add(functionComponent);
		Scene.addFunctionComponent((GameControllerI) functionComponent);
	}
	
	public List<FunctionComponent> getFunctionComponents() {
		return functionComponents;
	}*/

	public void addScript(Script script) {
		if (scripts == null) {
			scripts = new ArrayList<>();
		}
		scripts.add(script);
		script.setOwner(this);

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

	public List<Animator> getAnimatorsToList() {
		Collection<Animator> values = getAnimators().values();

		return values.stream().collect(Collectors.toList());
	}

	public void addAnimator(String name, Animator anm) {
		this.animatorControl.addAnimator(name, anm);

	}

	public Map<String, Animator> getAnimators() {

		return this.getAnimatorControl().getAnimators();
	}

	public List<Animator> getAnimatorList() {
		return this.getAnimatorControl().getAnimators().values().stream()
				.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "GameObject [animatorControl=" + animatorControl + "]";
	}

}
