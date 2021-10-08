package test.robot;

import java.awt.Point;

public class Points {
	public static Point subtract(Point src, Point dest) {
		Point p = new Point();
		p.setLocation(dest.getX() - src.getX(), dest.getY() - src.getY());
		return p;
	}

	public static Point add(Point src, Point dest) {
		Point p = new Point();
		p.setLocation(dest.getX() + src.getX(), dest.getY() + src.getY());
		return p;
	}

	public static Point negative(Point point) {
		Point p = new Point();
		p.setLocation(-point.getX(), -point.getY());
		return p;
	}
}
