package idv.fc.taglib.component.listgroup;

import idv.fc.taglib.component.common.TaglibComponent;
import idv.fc.taglib.component.common.TaglibRenderer;
import idv.fc.taglib.component.listgroup.listmodel.ListGroupModel;
import idv.fc.taglib.component.listgroup.renderer.ListGroupRenderere;

public class ListGroup<T> implements TaglibComponent<T> {
	private ListGroupModel<T> model;
	private TaglibRenderer<T> renderer;

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

	@Override
	public String getBodyResult(int index) {
		return ((ListGroupRenderere<T>) this.renderer)
				.getRenderedBody(this.model.getItem(index));
	}

	@Override
	public String getTitleResult() {
		return this.renderer.getRenderedTitle();
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
