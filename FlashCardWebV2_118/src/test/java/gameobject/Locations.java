package gameobject;

import java.awt.Point;

public class Locations {

	public static void location(Component comp) {
		Point relP = comp.getRelevantPosition();
		Point absP = new Point();
		Point parentP = comp.getParentComponent().getAbsolutePosition();
		absP.x = parentP.x + relP.x;
		absP.y = parentP.y + relP.y;
		comp.setAbsolutePosition(absP);
	}

}
