package idv.taglib.component.itf;

import idv.taglib.controlmodel.Handler;

public interface TaglibRenderer<T> {

	String getRenderedHeader(Handler handler);

	String getRenderedBody(Handler handler);

	String getRenderedFooter(Handler handler);

}
