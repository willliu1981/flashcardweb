package idv.fc.taglib.component.listgroup.listmodel;

public interface ListGroupModel<T> {

	public void addItem(T model);
	
	public T getItem(int index);
}