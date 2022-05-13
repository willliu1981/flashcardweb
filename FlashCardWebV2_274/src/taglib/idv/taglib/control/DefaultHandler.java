package idv.taglib.control;

import java.util.HashMap;
import java.util.Map;

public class DefaultHandler implements Handler {
	private Map<String, String> attrs = new HashMap<>();

	@Override
	public void setAttribute(String name, String attr) {
		this.attrs.put(name, attr);

	}

	@Override
	public String getAttribute(String name) {
		return attrs.get(name);
	}

	@Override
	public Map<String, String> getAttributes() {
		return attrs;
	}

}
