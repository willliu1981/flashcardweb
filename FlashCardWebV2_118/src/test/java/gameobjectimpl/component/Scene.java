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

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import gameobjectimpl.animator.AnimatorControl;
import gameobjectimpl.component.impl.HasScript;
import gameobjectimpl.component.impl.Person;
import gameobjectimpl.test.Test10;
import gameobjectimpl.tool.Animators;
import gameobjectimpl.tool.Graphs;
import gameobjectimpl.tool.Locations;
import idv.tool.Debug;

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

	protected Scene() {

	}

	private static class GameTask extends TimerTask {
		private JComponent comp;
		private boolean isStarted = false;

		private GameTask(JComponent comp) {
			this.comp = comp;
		}

		@Override
		public void run() {
			if (!isStarted) {
				//functionComponents.forEach(GameControllerI::start);

				List<HasScript> sceneComps = getSceneComponentsWithScript();

				isStarted = true;
			}

			//functionComponents.forEach(GameControllerI::update);

			//Scene.refreshPosture();

			//comp.repaint();

		}

	}

	public static List<Component> getSceneComponents() {
		return sceneComponents;
	}

	public static String testMsg(String a) {
		return "msg=" + a;
	}

	public static List<HasScript> getSceneComponentsWithScript() {
		//*
		try (MockedStatic<?> utilities = Mockito.mockStatic(Scene.class)) {
			utilities.when(Scene::getSceneComponents).thenReturn(Test10.lists);
			
			List<Component> sceneComps = getSceneComponents();
			List<HasScript> newComps = sceneComps.stream()
					.filter(c -> c instanceof HasScript).map(c2 -> (HasScript) c2)
					.collect(Collectors.toList());
			
			return newComps;

		} //*/
	}

	public static Component findSceneComponent(String name) {
		Optional<Component> findFirst = sceneComponents.stream()
				.filter(comp -> comp.getName().equals(name)).findFirst();
		return findFirst.get();
	}

	public static List<Component> findActivedGameObjectByOwner(String name) {
		//Component findSceneComponent = findSceneComponent(name);
		List<Component> collect = activedGameObjects.stream()
				.filter(go -> go.getOwner().equals(name)).collect(Collectors.toList());
		return collect;
	}

	public static void addSceneComponent(Component component) {
		Scene.sceneComponents.add(component);
		component.setParentComponent(parent);
		addActivedGameObject(component);

	}

	public static void locating() {
		if (sceneComponents != null) {
			sceneComponents.forEach(comp -> {
				Locations.locating(comp);
			});

		}

	}

	public static void addActivedGameObject(Component component) {
		activedGameObjects.add(component);
	}

	public static List<Component> getActivedGameObjects() {
		return activedGameObjects;
	}

	public static void run(JComponent comp) {
		task = new GameTask(comp);
		timer.schedule(task, 200, 100);
	}

	public static List<AnimatorControl> getActivedAnimatorControls() {
		List<AnimatorControl> collect = Scene.getSceneComponents().stream()
				.filter(cmpt -> cmpt instanceof HasAnimation)
				.map(cmpnt -> ((GameObject) cmpnt).getAnimatorControl())
				.collect(Collectors.toList());

		return collect;
	}

	/*
	 * 刷新所有作用中的動畫節點
	 */
	public static void refreshPosture() {
		List<AnimatorControl> controls = getActivedAnimatorControls();
		controls.stream().forEach(cr -> {
			Animators.animatorTick(cr);
		});
	}

	public static void paintActivedGameObjects(Graphics g) {
		List<Component> gameObjects = Scene.getActivedGameObjects();
		if (!gameObjects.isEmpty()) {
			gameObjects.forEach(go -> {
				Graphs.paintForActivedGameObjects(g, go);
			});

		}
	}

}
