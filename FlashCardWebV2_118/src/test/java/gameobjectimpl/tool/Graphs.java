package gameobjectimpl.tool;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.component.Component;
import gameobjectimpl.component.ComponentAdapter;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.impl.Person;
import idv.tool.Debug;

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

	}

	/**
	 * 
	 * @param g
	 * @param adapters 具有 動畫創建的功能屬性
	 * @param target
	 * @param frameIndex
	 */
	public static void paintForCreatePerson(Graphics g,
			List<ComponentAdapter> adapters) {

		adapters.stream().forEach(adpt -> {
			if (adpt.isPaintable()) {
				Graphics2D g2d = (Graphics2D) g;
				if (adpt.isSelected()) {
					g.setColor(Color.red);
				} else {
					g.setColor(Color.blue);
				}
				g2d.setStroke(new BasicStroke(3));
				g2d.drawRoundRect(adpt.getAbsolutePosition().x,
						adpt.getAbsolutePosition().y, 50, 50, 50, 50);
			}
		});

	}
}
