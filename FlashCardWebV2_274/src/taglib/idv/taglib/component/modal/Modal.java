package idv.taglib.component.modal;

import idv.taglib.component.itf.TaglibComponent;
import idv.taglib.component.itf.TaglibRenderer;
import idv.taglib.handle.DefaultHandler;
import idv.taglib.handle.Handler;

public class Modal<T> implements TaglibComponent<T> {
	private Handler handler = new DefaultHandler();
	private TaglibRenderer<T> renderer;

	@Override
	public String getHeaderResult() {
		return renderer.getRenderedHeader();
	}

	@Override
	public String getFooterResult() {
		return renderer.getRenderedFooter(handler);
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
