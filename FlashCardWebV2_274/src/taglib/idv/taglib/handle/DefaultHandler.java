package idv.taglib.handle;

import java.util.HashMap;
import java.util.Map;

public class DefaultHandler implements Handler {
	private Map<String, Object> attrs = new HashMap<>();

	@Override
	public void setAttribute(String name, Object attr) {
		this.attrs.put(name, attr);

	}

}
