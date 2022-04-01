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
	private static List<Component> gameObjects = new ArrayList<>();
	

	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	public void addComponent(Component component) {
		this.components.add(component);
		component.setParentComponent(parent);
		addGameObject(component);
	}

	public void locating() {
		components.forEach(comp -> {
			Locations.locating(comp);
		});

	}
	
	public static void addGameObject(Component component) {
		gameObjects.add(component);
	}

	public static List<Component> getGameObjects() {
		return gameObjects;
	}
	
	

}
