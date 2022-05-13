package idv.taglib.component.itf;

import idv.excpetion.ExceptionFactory;
import idv.taglib.control.Handler;

public interface TaglibRenderer<T> extends Renderable {
	static String EMPTY = "";

	String getRenderedHeader();

	String getRenderedBody();

	String getRenderedFooter();

	default String getRenderedFooter(Handler handler) {
		throw ExceptionFactory
				.getDefaultUnsupportedOperationException(new Object() {
				});

	}
}
