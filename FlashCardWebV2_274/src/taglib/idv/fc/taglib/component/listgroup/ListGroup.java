package idv.fc.taglib.component.listgroup;

import java.util.List;

import idv.fc.taglib.component.listgroup.listmodel.ListGroupModel;
import idv.fc.taglib.component.listgroup.renderer.ListGroupRenderer;

public class ListGroup<T> {
	private ListGroupModel<T> model;
	private ListGroupRenderer<T> renderer;

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

	public String getResult(int index) {
		return this.renderer.getRenderedResult(this.model.getItem(index));
	}
	
	

}
