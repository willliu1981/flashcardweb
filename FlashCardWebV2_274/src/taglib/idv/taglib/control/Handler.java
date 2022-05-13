package idv.taglib.control;

public interface Handler {
	public final static String EMPTY = "";
	public final static String BODY = "";

	void setAttribute(String name, Object attr);

	Object getAttribute(String name);
}
