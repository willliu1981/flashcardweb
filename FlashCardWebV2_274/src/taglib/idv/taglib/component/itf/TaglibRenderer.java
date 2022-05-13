package idv.taglib.component.itf;

import idv.taglib.control.Handler;

public interface TaglibRenderer<T> {

	String getRenderedHeader(Handler handler);

	String getRenderedBody(Handler handler);

	String getRenderedFooter(Handler handler);

}
