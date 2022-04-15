package gameobjectimpl.animator;

import java.util.List;
import java.util.Map;

import idv.tool.Debug;

public class AnimatorBuilder {

	private Map<String, String> animatorJsons;

	public AnimatorBuilder() {
	}

	public Map<String, String> getAnimatorJsons() {
		return animatorJsons;
	}

	public void setAnimatorJsons(Map<String, String> animatorJsons) {
		this.animatorJsons = animatorJsons;
	}

}
