package test.robot;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Component {
	private String name;
	private List< Component> attach =new ArrayList<>();
	private Component superAttach;
	private Point position;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Component> getAttachs() {
		return attach;
	}
	public void attachComponent(Component component) {
		this.attach .add(component);
	}
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	public Component getSuperComponent() {
		return superAttach;
	}
	public void setSuperComponent(Component superComponent) {
		this.superAttach = superComponent;
	}
	
	
	
	
}
