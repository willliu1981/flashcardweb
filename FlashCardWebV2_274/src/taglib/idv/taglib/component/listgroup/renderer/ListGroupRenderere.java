package idv.taglib.component.listgroup.renderer;

import idv.taglib.component.itf.TaglibRenderer;
import idv.taglib.control.Handler;

public abstract class ListGroupRenderere<T> implements TaglibRenderer<T> {

	public abstract String getRenderedEachBody(T model);

	public String getRenderedBody(Handler handler) {
		return Handler.EMPTY;
	};
}
