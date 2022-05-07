package idv.fc.taglib.component.listgroup;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import idv.fc.taglib.component.listgroup.listmodel.ListGroupModel;
import idv.fc.taglib.component.listgroup.renderer.ListGroupRenderer;

public class ListGroup<T> {
	private ListGroupModel<T> model;
	private ListGroupRenderer<T> renderer;

	public ListGroup() {

	}

	public int getItemSize() {
		return this.model.getItemSize();
	}

	public String getHeading() {

		return null;
	}

	public List<String> getTexts() {

		return null;
	}

	public void setModel(ListGroupModel<T> model) {
		this.model = model;
	}

	public void setRenderer(ListGroupRenderer<T> renderer) {
		this.renderer = renderer;
	}

	public String getDataResult(int index) {
		return this.renderer.getRenderedResult(this.model.getItem(index));
	}

	public String getTitleResult() {
		return this.renderer.getRenderedBefore();
	}

}
