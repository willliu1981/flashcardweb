package idv.fc.taglib.listgroup.listmodel;

import java.util.ArrayList;
import java.util.List;

import idv.fc.taglib.listgroup.listmodel.renderer.ListGroupRenderer;

public class ListGroupModel<T> {
	private T model;
	private ListGroupRenderer<T> listRenderer;
	private List<T> elements = new ArrayList<>();

	public ListGroupModel(T model) {
		this.model = model;

	}
	
	

}
