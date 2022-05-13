package idv.taglib.control;

import java.util.Map;

public interface Handler {
	public final static String EMPTY = "";
	public final static String BODY = "${BODY}";

	void setAttribute(String name, String attr);

	String getAttribute(String name);

	Map<String, String> getAttributes();
	
	
}
