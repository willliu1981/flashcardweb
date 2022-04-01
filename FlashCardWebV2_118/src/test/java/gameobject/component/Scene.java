package gameobject.component;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComponent;

import gameobject.control.GameControler;
import gameobject.tool.Locations;
import idv.tool.Debug;

public class Scene {

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

	private static GameTask task;

	private static Timer timer = new Timer();

	private static GameObject parent;
	{
		parent = new GameObject();
		parent.setAbsolutePosition(new Point(0, 0));
	}

	private static List<Component> sceneComponent = new ArrayList<>();
	private static List<Component> gameObjects = new ArrayList<>();

	public static List<Component> getSceneComponent() {
		return sceneComponent;
	}

	public void setSceneComponent(List<Component> components) {
		Scene.sceneComponent = components;
	}

	public void addSceneComponent(Component component) {
		Scene.sceneComponent.add(component);
		component.setParentComponent(parent);
		addGameObject(component);
	}

	public static void locating() {
		sceneComponent.forEach(comp -> {
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
