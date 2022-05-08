package idv.fc.taglib.component.listgroup.renderer;

import idv.fc.taglib.component.common.TaglibRenderer;

public abstract class ListGroupRenderere<T> implements TaglibRenderer<T> {

	public abstract String getRenderedBody(T model);

	public String getRenderedBody() {
		return EMPTY;
	};
}
