package gameobjectimpl.component;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComponent;

import gameobjectimpl.control.GameControler;
import gameobjectimpl.tool.Locations;
import idv.tool.Debug;

public class Scene {

	private static GameTask task;

	private static Timer timer = new Timer();

	private static GameObject parent;
	{
		parent = new GameObject();
		parent.setAbsolutePosition(new Point(0, 0));
	}

	private static List<Component> sceneComponents = new ArrayList<>();
	private static List<Component> gameObjects = new ArrayList<>();

	private static class GameTask extends TimerTask {
		private JComponent comp;

		private GameTask(JComponent comp) {
			this.comp = comp;
		}

		@Override
		public void run() {
			GameControler.move();
			locating();
			comp.repaint();
		
		}

	}

	public static List<Component> getSceneComponents() {
		return sceneComponents;
	}

	public static Component findSceneComponent(String name) {
		Optional<Component> findFirst = sceneComponents.stream()
				.filter(comp -> comp.getName().equals(name)).findFirst();
		return findFirst.get();
	}

	public void setSceneComponents(List<Component> components) {
		Scene.sceneComponents = components;
	}

	public void addSceneComponent(Component component) {
		Scene.sceneComponents.add(component);
		component.setParentComponent(parent);
		addGameObject(component);
	}

	public static void locating() {
		sceneComponents.forEach(comp -> {
			Locations.locating(comp);
		});

	}

	public static void addGameObject(Component component) {
		gameObjects.add(component);
	}

	public static List<Component> getGameObjects() {
		return gameObjects;
	}

	public static void run(JComponent comp) {
		task = new GameTask(comp);
		timer.schedule(task, 1000, 500);
	}

}
