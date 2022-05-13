package idv.taglib.component.listgroup;

import idv.taglib.component.adapter.TablibComponentAdapter;
import idv.taglib.component.itf.TaglibRenderer;
import idv.taglib.component.listgroup.renderer.ListGroupRenderere;
import idv.taglib.listgroup.listmodel.ListGroupModel;

public class ListGroup<T> extends TablibComponentAdapter<T> {
	private ListGroupModel<T> model;
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

}
