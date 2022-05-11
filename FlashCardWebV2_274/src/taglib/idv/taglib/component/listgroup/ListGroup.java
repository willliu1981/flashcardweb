package idv.taglib.component.listgroup;

import idv.taglib.component.common.TaglibComponent;
import idv.taglib.component.common.TaglibRenderer;
import idv.taglib.component.listgroup.renderer.ListGroupRenderere;
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
	public String getHeaderResult() {
		return this.renderer.getRenderedHeader();
	}

	@Override
	public String getFooterResult() {
		return this.renderer.getRenderedFooter();
	}

	@Override
	public String getBodyResult() {
		return ((ListGroupRenderere<T>) this.renderer).getRenderedBody();
	}

}
