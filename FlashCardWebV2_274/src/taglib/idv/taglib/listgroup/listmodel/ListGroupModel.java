package idv.taglib.listgroup.listmodel;

public interface ListGroupModel<T> {

	public void addItem(T model);
	
	public T getItem(int index);
	
	public int getItemSize();
}
