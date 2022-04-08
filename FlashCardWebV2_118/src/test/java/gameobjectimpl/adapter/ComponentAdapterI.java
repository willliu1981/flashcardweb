package gameobjectimpl.adapter;

import java.awt.Point;

import gameobjectimpl.component.Component;

public interface ComponentAdapterI extends AdapterI<Component> {

	public void setPreviosAbsolutePosition(Point p);

	public Point getPreviosAbsolutePosition();

	public void setAbsolutePosition(Point absolutePosition);

	public Point getAbsolutePosition();
}
