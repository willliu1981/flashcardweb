package idv.fc.taglib.component.listgroup.renderer;

import javax.servlet.http.HttpServletRequest;

import idv.fc.model.Flashcard;

public interface ListGroupRenderer<T> {
	static String SKIP = "rtn_skip";


	String getRenderedAfter(T model);

	String getRenderedBefore(HttpServletRequest request);

	String getRenderedResult(T model, HttpServletRequest request);
}
