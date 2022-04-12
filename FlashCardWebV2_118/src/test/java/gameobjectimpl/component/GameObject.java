package gameobjectimpl.component;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.animator.AnimatorControl;
import gameobjectimpl.control.ScriptI;

public class GameObject extends Component {
	//private List<FunctionComponent> functionComponents = new ArrayList<>();

	private AnimatorControl animatorControl;
	private List<ScriptI> scripts;

	public GameObject() {

	}

	/*public void addFunctionComponent(FunctionComponent functionComponent) {
		this.functionComponents.add(functionComponent);
		Scene.addFunctionComponent((GameControllerI) functionComponent);
	}
	
	public List<FunctionComponent> getFunctionComponents() {
		return functionComponents;
	}*/

	public void addScript(ScriptI script) {
		if (scripts == null) {
			scripts = new ArrayList<>();
		}
		scripts.add(script);
		script.setOwner(this);

	}

	public int getX() {
		return this.getRelevantPosition().x;
	}

	public int getY() {
		return this.getRelevantPosition().y;
	}

	public void setX(int x) {
		this.setRelevantPosition(new Point(x, this.getY()));
	}

	public void setY(int y) {
		this.setRelevantPosition(new Point(this.getX(), y));
	}

	public List<ScriptI> getScripts() {

		return this.scripts;
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
