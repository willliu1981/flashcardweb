package idv.fc.taglib.component.common;

import java.util.ArrayList;
import java.util.List;

public class Script {
	List<String> scripts = new ArrayList<>();

	public Script addScript(String script) {
		this.scripts.add(script);
		return this;
	}

	public List<String> getScripts() {
		return this.scripts;
	}
}
