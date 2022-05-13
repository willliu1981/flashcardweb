package idv.taglib.component.itf;

import idv.excpetion.MyUnsupportedOperationException;
import idv.taglib.handle.Handler;

public interface TaglibRenderer<T> extends Renderable {
	static String EMPTY = "";

	String getRenderedHeader();

	String getRenderedBody();

	String getRenderedFooter();

	default String getRenderedFooter(Handler handler) {
		throw new MyUnsupportedOperationException(
				new Object().getClass().getEnclosingMethod() + " 方法尚未實作");
	}
}
