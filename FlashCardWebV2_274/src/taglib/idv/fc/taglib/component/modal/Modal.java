package idv.fc.taglib.component.modal;

import idv.fc.taglib.component.common.TaglibComponent;
import idv.fc.taglib.component.common.TaglibRenderer;

public class Modal<T> implements TaglibComponent<T> {

	private TaglibRenderer<T> renderer;

	@Override
	public String getBodyResult(int index) {
		return null;
	}

	@Override
	public String getTitleResult() {
		return renderer.getRenderedTitle();
	}

	@Override
	public String getFooterResult() {
		return renderer.getRenderedFooter();
	}

	@Override
	public void setRenderer(TaglibRenderer<T> renderer) {
		this.renderer = renderer;
	}

}
