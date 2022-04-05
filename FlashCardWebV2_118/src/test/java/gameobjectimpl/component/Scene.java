package gameobjectimpl.component;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

import javax.swing.JComponent;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.control.GameControler;
import gameobjectimpl.tool.Animators;
import gameobjectimpl.tool.Graphs;
import gameobjectimpl.tool.Locations;

public class Scene {

	private static GameTask task;

	private static Timer timer = new Timer();

	private static GameObject parent;
	static {
		parent = new GameObject();
		parent.setName("scene");
		parent.setAbsolutePosition(new Point(0, 0));
	}

	private static List<Component> sceneComponents = new ArrayList<>();
	private static List<Component> activedGameObjects = new ArrayList<>();

	private Scene() {

	}

	private static class GameTask extends TimerTask {
		private JComponent comp;

		private GameTask(JComponent comp) {
			this.comp = comp;
		}

		@Override
		public void run() {
			GameControler.move();
			//locating();
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

	public static List<Component> findActivedGameObjectByOwner(String name) {
		Component findSceneComponent = findSceneComponent(name);
		List<Component> collect = activedGameObjects.stream()
				.filter(go -> go.getOwner().equals(name)).collect(Collectors.toList());
		return collect;
	}

	public static void setSceneComponents(List<Component> components) {
		Scene.sceneComponents = components;
	}

	public static void addSceneComponent(Component component) {
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
		activedGameObjects.add(component);
	}

	public static List<Component> getActivedGameObjects() {
		return activedGameObjects;
	}

	public static void run(JComponent comp) {
		task = new GameTask(comp);
		timer.schedule(task, 1000, 100);
	}

	public static List<Animator> getActivedAnimators() {
		List<Animator> anms = Scene.getSceneComponents().stream()
				.filter(cmpt -> cmpt instanceof HasAnimation)
				.map(cmpnt -> ((HasAnimation) cmpnt).getAnimators())
				.flatMap(List::stream).collect(Collectors.toList());

		return anms;
	}

	public static void refreshPosture() {
		List<Animator> activedAnimators = getActivedAnimators();

		activedAnimators.forEach(anm -> {
			int currIndex = anm.getCurrentKeyIndex();
			Animators.setPosture((HasAnimation) anm.getOwner(), currIndex);
			anm.setCurrentKeyIndex(currIndex + 1);
		});
	}

	public static void paintActivedGameObjects(Graphics g) {
		List<Component> gameObjects = Scene.getActivedGameObjects();
		if (!gameObjects.isEmpty()) {
			gameObjects.forEach(go -> {
				Graphs.paint(g, go);
			});

		}
	}

}
