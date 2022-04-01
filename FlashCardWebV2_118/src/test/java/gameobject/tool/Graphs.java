package gameobject.tool;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import gameobject.Component;

public class Graphs {

	public static void paint(Graphics g, Component comp) {
		Point p = comp.getAbsolutePosition();
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawOval(p.x, p.y, 50, 50);
	}
}
