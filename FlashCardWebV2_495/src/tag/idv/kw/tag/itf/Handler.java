package idv.kw.tag.itf;

import java.util.Map;

public interface Handler {
	public final static String EMPTY = "";

	/*
	 * 設置於 renderer ,用於將jsp body 取代 renderer 中 BODY 佔位符位置
	 */
	public final static String BODY = "${_BODY}";

	void setAttribute(String name, String attr);

	String getAttribute(String name);

	Map<String, String> getAttributes();

}
