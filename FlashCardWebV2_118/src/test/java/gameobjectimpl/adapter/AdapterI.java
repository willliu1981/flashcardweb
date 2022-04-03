package gameobjectimpl.adapter;

public interface AdapterI<T> {
	public void setTarget(T t);

	public T getTarget();
}
