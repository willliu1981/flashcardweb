package idv.taglib.component.listgroup.renderer;

import idv.taglib.component.common.TaglibRenderer;

public abstract class ListGroupRenderere<T> implements TaglibRenderer<T> {

	public abstract String getRenderedEachBody(T model);

	public String getRenderedBody() {
		return EMPTY;
	};
}
