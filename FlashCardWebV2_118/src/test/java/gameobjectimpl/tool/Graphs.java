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
	private static final Integer DEFAULTWIDTH = 50;
	private static final Integer DEFAULTHEIGHT = 50;

	public static void paint(Graphics g, Component comp) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.fillRoundRect(comp.getAbsolutePosition().x, comp.getAbsolutePosition().y,
				DEFAULTWIDTH, DEFAULTHEIGHT, DEFAULTWIDTH, DEFAULTHEIGHT);
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
		paintForCreatePerson(g, adapters, Color.blue, Color.red);
	}

	public static void paintForCreatePersonPrevious(Graphics g,
			List<ComponentAdapter> adapters) {
		paintForCreatePersonPrevious(g, adapters, Color.magenta, Color.orange);
	}

	private static void paintForCreatePersonPrevious(Graphics g,
			List<ComponentAdapter> adapters, Color background, Color active) {
		adapters.stream().forEach(adpt -> {
			if (adpt.isPaintable()) {
				Graphics2D g2d = (Graphics2D) g;
				g.setColor(active);
				if (adpt.isSelected()) {
				} else {
					g.setColor(background);
				}
				g2d.setStroke(new BasicStroke(3));
				g2d.drawRoundRect(
						adpt.getPreviosAbsolutePosition().x - DEFAULTWIDTH / 2,
						adpt.getPreviosAbsolutePosition().y - DEFAULTHEIGHT / 2,
						DEFAULTWIDTH, DEFAULTHEIGHT, DEFAULTWIDTH, DEFAULTHEIGHT);
			}
		});

	}

	private static void paintForCreatePerson(Graphics g,
			List<ComponentAdapter> adapters, Color background, Color active) {
		g.setColor(Color.LIGHT_GRAY);
		g.drawLine(0, 300, 1000, 300);
		g.drawLine(0, 500, 1000, 500);

		g.drawLine(300, 0, 300, 1000);

		adapters.stream().forEach(adpt -> {
			if (adpt.isPaintable()) {
				Graphics2D g2d = (Graphics2D) g;
				if (adpt.isSelected()) {
					g.setColor(active);
				} else {
					g.setColor(background);
				}
				g2d.setStroke(new BasicStroke(3));
				g2d.drawRoundRect(adpt.getAbsolutePosition().x - DEFAULTWIDTH / 2,
						adpt.getAbsolutePosition().y - DEFAULTHEIGHT / 2, DEFAULTWIDTH,
						DEFAULTHEIGHT, DEFAULTWIDTH, DEFAULTHEIGHT);
			}
		});
	}
}
