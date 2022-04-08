package gameobjectimpl.adapter;

import java.awt.Point;

public interface AdapterI<T> {
	public void setTarget(T t);

	public T getTarget();

}
