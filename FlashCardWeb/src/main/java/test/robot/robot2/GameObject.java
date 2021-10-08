package test.robot.robot2;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class GameObject {
	private String name;
	private Component component;
	private Point position;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(int x, int y) {
		this.position = new Point(x, y);
	}

}
