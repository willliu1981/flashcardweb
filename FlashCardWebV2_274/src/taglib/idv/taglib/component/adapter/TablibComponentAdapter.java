package idv.taglib.component.adapter;

import idv.taglib.component.itf.TaglibComponent;
import idv.taglib.component.itf.TaglibRenderer;
import idv.taglib.controlmodel.Result;

public abstract class TablibComponentAdapter<T> implements TaglibComponent<T> {
	protected TaglibRenderer<T> renderer;

	@Override
	public Result getHeaderResult() {
		return createResult(h -> renderer.getRenderedHeader(h));
	}

	@Override
	public Result getBodyResult() {
		return createResult(h -> renderer.getRenderedBody(h));
	}

	@Override
	public Result getFooterResult() {
		return createResult(h -> renderer.getRenderedFooter(h));
	}
}
