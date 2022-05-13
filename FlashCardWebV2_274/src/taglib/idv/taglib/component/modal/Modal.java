package idv.taglib.component.modal;

import idv.taglib.component.itf.TaglibComponent;
import idv.taglib.component.itf.TaglibRenderer;
import idv.taglib.control.Result;

public class Modal<T> implements TaglibComponent<T> {
	private TaglibRenderer<T> renderer;

	@Override
	public Result getHeaderResult() {
		/*	Handler defaultHandler = new DefaultHandler();
			String renderedHeader = renderer.getRenderedHeader(defaultHandler);*/
		return createResult(h -> renderer.getRenderedHeader(h));
	}

	@Override
	public Result getBodyResult() {
		/*	DefaultHandler defaultHandler = new DefaultHandler();
			String renderedBody = renderer.getRenderedBody(defaultHandler);*/
		return createResult(h -> renderer.getRenderedBody(h));
	}

	@Override
	public Result getFooterResult() {
		/*		Handler defaultHandler = new DefaultHandler();
				String renderedFooter = renderer.getRenderedFooter(defaultHandler);
				Result result = new Result();
				result.setHandler(defaultHandler);
				result.setResult(renderedFooter);*/
		return createResult(h -> renderer.getRenderedFooter(h));
	}

	@Override
	public void setRenderer(TaglibRenderer<T> renderer) {
		this.renderer = renderer;
	}

}
