package test.robot.robot2;

import java.awt.Point;
import java.awt.Rectangle;

public class ComponentFactory {

	public static Rectangle getRect(Component thisComp) {
		Point superAbsolute = thisComp.getSuperComponent().getAbsolute();
		Point pivotAbsoulte = Points.subtract(superAbsolute, thisComp.getPosition());
		thisComp.setAbsolute(superAbsolute);
		Point offset = Points.subtract(thisComp.getRect().getLocation(),
				thisComp.getPivot());
		Rectangle rectOffset = Rectangles.offset(thisComp.getRect(),
				Points.negative(offset));
		Rectangle rectAbsoult = Rectangles.offset(rectOffset, pivotAbsoulte);

		return rectAbsoult;
	}

}
