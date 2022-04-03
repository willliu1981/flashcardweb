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

	public static void paintForCreatePerson(Graphics g, List<ComponentAdapter> adapters,
			GameObject target, Integer frameIndex) {
		Person person = (Person) target;
		Animator animator = person.getAnimator();

		animator.getKeyFrames().stream().filter(k -> k.getKeyIndex().equals(frameIndex))
				.forEach(key -> {
					Point position = key.getPosition();

					ComponentAdapter adapter = adapters.stream()
							.filter(adpt -> adpt.getName().equals(key.getKeyName()))
							.findFirst().get();

					Graphics2D g2d = (Graphics2D) g;
					if (adapter.isSelected()) {
						g.setColor(Color.red);
					} else {
						g.setColor(Color.blue);
					}
					g2d.setStroke(new BasicStroke(3));
					g2d.fillRoundRect(key.getPosition().x, key.getPosition().y, 50, 50,
							50, 50);
				});

		//Point p = comp.getAbsolutePosition();

	}
}
