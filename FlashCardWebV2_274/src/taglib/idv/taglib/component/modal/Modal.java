package idv.taglib.component.modal;

import idv.taglib.component.common.TaglibComponent;
import idv.taglib.component.common.TaglibRenderer;

public class Modal<T> implements TaglibComponent<T> {

	private TaglibRenderer<T> renderer;

	@Override
	public String getHeaderResult() {
		return renderer.getRenderedHeader();
	}

	@Override
	public String getFooterResult() {
		return renderer.getRenderedFooter();
	}

	@Override
	public void setRenderer(TaglibRenderer<T> renderer) {
		this.renderer = renderer;
	}

	@Override
	public String getBodyResult() {
		return renderer.getRenderedBody();
	}

}