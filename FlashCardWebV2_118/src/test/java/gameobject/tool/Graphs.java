package gameobject.tool;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import gameobject.component.Component;
import gameobject.component.ComponentAdapter;

public class Graphs {

	public static void paint(Graphics g, Component comp) {
		Point p = comp.getAbsolutePosition();
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawOval(p.x, p.y, 50, 50);
	}

	public static void paintForCreatePerson(Graphics g, ComponentAdapter comp) {

		Point p = comp.getAbsolutePosition();
		Graphics2D g2d = (Graphics2D) g;
		if (comp.isSelected()) {
			g.setColor(Color.red);
		} else {
			g.setColor(Color.blue);
		}
		g2d.setStroke(new BasicStroke(3));
		g2d.fillRoundRect(p.x, p.y, 50, 50, 50, 50);
		//g2d.drawOval(p.x, p.y, 50, 50);

	}
}
