package idv.taglib.control;

import java.util.HashMap;
import java.util.Map;

public class DefaultHandler implements Handler {
	private Map<String, Object> attrs = new HashMap<>();

	@Override
	public void setAttribute(String name, Object attr) {
		this.attrs.put(name, attr);

	}

	@Override
	public Object getAttribute(String name) {
		return attrs.get(name);
	}

}
