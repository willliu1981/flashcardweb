package gameobjectimpl.tool;

import java.util.List;
import java.util.stream.Collectors;

import gameobjectimpl.component.Component;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.Scene;
import idv.tool.Debug;

public class GameObjectScanner {
	public static List<Component> findComponents(GameObject target) {
		List<Component> list = Scene.getGameObjects().stream()
				.filter(comp ->{
					boolean res=comp.getOwner().equals(target.getOwner());
					
					return res;
				})
				.collect(Collectors.toList());
		return list;
	}
}
