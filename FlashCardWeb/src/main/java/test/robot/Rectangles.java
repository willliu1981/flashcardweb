package test.robot;

import java.awt.Point;
import java.awt.Rectangle;

public class Rectangles {

	public static Rectangle offset(Rectangle rect, Point offset) {
		Rectangle newRect = new Rectangle();
		Point p = rect.getLocation();
		newRect.setLocation(Points.add(p, offset));
		newRect.setSize(newRect.getSize());

		return newRect;
	}

}
