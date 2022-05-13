package idv.taglib.component.modal;

import idv.taglib.component.itf.TaglibComponent;
import idv.taglib.component.itf.TaglibRenderer;
import idv.taglib.control.DefaultHandler;
import idv.taglib.control.Handler;
import idv.taglib.control.Result;

public class Modal<T> implements TaglibComponent<T> {
	private Handler footerHandler = new DefaultHandler();
	private TaglibRenderer<T> renderer;

	@Override
	public String getHeaderResult() {
		return renderer.getRenderedHeader();
	}

	@Override
	public String getFooterResult() {
		return renderer.getRenderedFooter(footerHandler);
	}

	@Override
	public Result getFooterResult2() {
		String renderedFooter = renderer.getRenderedFooter(footerHandler);
		Result result = new Result();
		result.setHandler(footerHandler);
		result.setResult(renderedFooter);
		return result;
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
