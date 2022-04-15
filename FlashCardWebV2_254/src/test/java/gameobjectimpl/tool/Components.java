package gameobjectimpl.tool;

import java.util.List;

import gameobjectimpl.component.ComponentAdapter;

public class Components {

	public static void clearSelected(List<ComponentAdapter> components) {
		components.forEach(comp -> {
			comp.setSelected(false);
		});
	}
}
