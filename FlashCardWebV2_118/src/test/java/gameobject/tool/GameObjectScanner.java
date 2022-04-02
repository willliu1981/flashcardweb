package gameobject.tool;

import java.util.List;
import java.util.stream.Collectors;

import gameobject.component.Component;
import gameobject.component.GameObject;
import gameobject.component.Scene;
import idv.tool.Debug;

public class GameObjectScanner {
	public static List<Component> findComponent(GameObject target) {
		List<Component> list = Scene.getGameObjects().stream()
				.filter(comp ->{
					boolean res=comp.getOwner().equals(target.getOwner());
					
					return res;
				})
				.collect(Collectors.toList());
		return list;
	}
}
