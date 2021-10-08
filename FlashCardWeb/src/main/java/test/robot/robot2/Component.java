package test.robot.robot2;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Component {
	private String name;
	private List<Component> attachments = new ArrayList<>();
	private Component superAttach;
	private Point position;
	private Rectangle rect;
	private Point pivot;
	private Point absolute;

	public Component() {
		name = "";
		position = new Point(0, 0);
		rect = new Rectangle(0, 0, 10, 10);
		pivot = new Point(0, 0);

	}

	public boolean hasChilds() {
		return this.attachments.size() != 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Component> getAttachs() {
		return attachments;
	}

	public void attachComponent(Component component) {
		this.attachments.add(component);
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(int x, int y) {
		this.position = new Point(x, y);
	}

	public Component getSuperComponent() {
//		if (this.superAttach == null) {
//			this.superAttach = SceneFactory.getScene().getComponent();
//		}

		return superAttach;
	}

	public void setSuperComponent(Component superComponent) {
		this.superAttach = superComponent;
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(int x, int y, int w, int h) {
		this.rect = new Rectangle(x, y, w, h);
	}

	public Point getPivot() {
		return pivot;
	}

	public void setPivot(int x, int y) {
		this.pivot = new Point(x, y);
	}

	public Point getAbsolute() {
//		if (this.absolute == null) {
//			return SceneFactory.getScene().getAbsolute();
//		}
		return absolute;
	}

	public void setAbsolute(Point absolute) {
		this.absolute = absolute;
	}

}
