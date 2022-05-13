package idv.taglib.component.listgroup;

import idv.taglib.component.itf.TaglibComponent;
import idv.taglib.component.itf.TaglibRenderer;
import idv.taglib.component.listgroup.renderer.ListGroupRenderere;
import idv.taglib.control.Result;
import idv.taglib.listgroup.listmodel.ListGroupModel;

public class ListGroup<T> implements TaglibComponent<T> {
	private ListGroupModel<T> model;
	private TaglibRenderer<T> renderer;
	private int pointer = 0;

	public ListGroup() {

	}

	public int getItemSize() {
		return this.model.getItemSize();
	}

	public void setModel(ListGroupModel<T> model) {
		this.model = model;
	}

	@Override
	public void setRenderer(TaglibRenderer<T> renderer) {
		this.renderer = renderer;
	}

	protected String getBodyResultWithIndex(int index) {
		return ((ListGroupRenderere<T>) this.renderer)
				.getRenderedEachBody(this.model.getItem(index));
	}

	public String getNextBodyResult() {
		if (!this.hasNext()) {
			this.pointer = 0;
		}
		String bodyResultWithIndex = this.getBodyResultWithIndex(pointer);
		this.pointer++;
		return bodyResultWithIndex;
	}

	public boolean hasNext() {
		return this.pointer < this.model.getItemSize();
	}

	@Override
	public Result getHeaderResult() {
		return this.renderer.getRenderedHeader(null);
	}

	@Override
	public Result getFooterResult() {
		return this.renderer.getRenderedFooter(null);
	}

	@Override
	public Result getBodyResult() {
		return ((ListGroupRenderere<T>) this.renderer).getRenderedBody(null);
	}

}
