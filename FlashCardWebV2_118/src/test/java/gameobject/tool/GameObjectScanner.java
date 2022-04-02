package gameobject.tool;

import java.util.List;
import java.util.stream.Collectors;

import gameobject.component.Component;
import gameobject.component.GameObject;
import gameobject.component.Scene;

public class GameObjectScanner {
	public static List<Component> findComponent(GameObject target) {
		List<Component> list = Scene.getGameObjects().stream().filter(comp -> true)
				.collect(Collectors.toList());
		return list;
	}
}
