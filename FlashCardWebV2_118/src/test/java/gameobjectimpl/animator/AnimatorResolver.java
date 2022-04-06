package gameobjectimpl.animator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import idv.tool.Debug;
import idv.tool.spring.MySpringUtil;

public class AnimatorResolver {
	private String config;

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public Map<String, Animator> getAnimators(String builderBeanName) {
		if (builderBeanName == null || builderBeanName.equals("")) {
			return null;
		}

		AnimatorBuilder builder = MySpringUtil.setApplicationContext(this.config)
				.getBean(builderBeanName, AnimatorBuilder.class);
		Map<String, String> animatorJsons = builder.getAnimatorJsons();

		Map<String, Animator> animators = new HashMap<>();
		animatorJsons.forEach((k, v) -> {
			Animator anm = parse(v);
			animators.put(k, anm);
		});

		return animators;
	}

	private Animator parse(String jsonString) {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, Animator.class);

	}

}
