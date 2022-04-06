package gameobjectimpl.animator;

import java.util.List;
import java.util.Map;

import idv.tool.Debug;

public class AnimatorBuilder {
	private AnimatorResolver resolver;
	private List<String> names;//用於取得resolver 中 map 的 vaule 的 key 

	public List<String> getNames() {
		return names;
	}

	public void setAddNames(List<String> names) {
		this.names = names;
	}

	public void setResolver(AnimatorResolver resolver) {
		this.resolver = resolver;
	}

	public Map<String, Animator> getAnimators() {
		return resolver.getAnimators(names);
	}

	public void setNames(List<String> names) {
		this.names = names;
	}
	
	
}
