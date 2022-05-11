package idv.taglib.listgroup.listmodel;

import java.util.ArrayList;
import java.util.List;

public class DefaultListGroupModel<T> implements ListGroupModel<T> {

	private List<T> items = new ArrayList<>();
	

	@Override
	public void addItem(T model) {
		this.items.add(model);
	}


	@Override
	public T getItem(int index) {
		return this.items.get(index);
	}


	@Override
	public int getItemSize() {
		return this.items.size();
	}
	
	
	
	

}
