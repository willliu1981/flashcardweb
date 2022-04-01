package gameobject;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import gameobject.tool.Locations;

public class Scene {
	private static GameObject parent;
	{
		parent = new GameObject();
		parent.setAbsolutePosition(new Point(0, 0));
	}

	private List<Component> components = new ArrayList<>();

	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	public void addComponent(Component component) {
		this.components.add(component);
		component.setParentComponent(parent);
	}

	public void locating() {
		components.forEach(comp -> {
			Locations.locating(comp);
		});

	}

}
