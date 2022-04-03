package gameobjectimpl.tool;

import java.awt.Point;
import java.util.List;

import gameobjectimpl.component.Component;
import idv.tool.Debug;

public class Locations {

	public static void locating(Component comp) {
		Point relP = comp.getRelevantPosition();
		Point absP = new Point();
		Point parentP = comp.getParentComponent().getAbsolutePosition();
		absP.x = parentP.x + relP.x;
		absP.y = parentP.y + relP.y;
		comp.setAbsolutePosition(absP);
		List<Component> subComps = comp.getComponents();
		if (subComps != null) {
			subComps.forEach(c -> {
				Locations.locating(c);
			});

		}

	}

}
