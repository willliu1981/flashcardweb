package idv.fc.taglib.component.listgroup.renderer;

import javax.servlet.http.HttpServletRequest;

public interface ListGroupRenderer<T> {
	static String SKIP = "rtn_skip";

	String getRenderedResult(T model);

	String getRenderedAfter(T model);

	String getRenderedBefore(HttpServletRequest request);
}
