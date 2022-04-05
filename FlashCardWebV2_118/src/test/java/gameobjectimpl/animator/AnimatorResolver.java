package gameobjectimpl.animator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class AnimatorResolver {
	private Map<String, Animator> animators;

	private Map<String, String> animatorByJsonStrings;

	public Map<String, Animator> getAnimators(List<String> keys) {
		this.initAnimators();

		Map<String, Animator> anms = new HashMap<>();
		animators.forEach((k, v) -> {
			if (keys.contains(k)) {
				anms.put(v.getName(), v);
			}
		});

		return anms;
	}

	public void setAnimators(Map<String, Animator> animators) {
		this.animators = animators;
	}

	public void setAddAnimator(Map<String, String> animatorByJsonStrings) {
		this.animatorByJsonStrings = animatorByJsonStrings;
	}

	private Animator parse(String jsonString) {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, Animator.class);

	}

	public void initAnimators() {
		if (this.animators == null) {
			animatorByJsonStrings.forEach((k, v) -> {
				Animator anm = parse(v);
				animators.put(k, anm);
			});
		}
	}

}
