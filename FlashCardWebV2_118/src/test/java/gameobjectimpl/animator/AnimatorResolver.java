package gameobjectimpl.animator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import idv.tool.Debug;
import idv.tool.spring.MySpringUtil;

public class AnimatorResolver {
	private String config;

	//private Map<String, Animator> animators;

	//private Map<String, String> animatorByJsonStrings;

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public Map<String, Animator> getAnimators(String builderBeanName) {
		AnimatorBuilder builder = MySpringUtil.setApplicationContext(this.config)
				.getBean(builderBeanName, AnimatorBuilder.class);

		return null;
	}

	/*
	public Map<String, Animator> getAnimators(List<String> keys) {
		this.initAnimators();
	
		Map<String, Animator> anms = new HashMap<>();
		animators.forEach((k, v) -> {
			if (keys.contains(k)) {
				anms.put("person1.walk-right", v);
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
	//*/

	/*
	private Animator parse(String jsonString) {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, Animator.class);
	
	}
	//*/

	/*
	public void initAnimators() {
		if (this.animators == null) {
			this.animators = new HashMap<>();
			animatorByJsonStrings.forEach((k, v) -> {
				Animator anm = parse(v);
				animators.put(k, anm);
			});
		}
	}
	//*/
}
