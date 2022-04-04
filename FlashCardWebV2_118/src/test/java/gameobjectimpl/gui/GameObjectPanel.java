package gameobjectimpl.gui;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import gameobjectimpl.component.Component;
import gameobjectimpl.component.Scene;
import gameobjectimpl.tool.Graphs;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class GameObjectPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GameObjectPanel() {
		setBorder(new LineBorder(Color.CYAN));

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		List<Component> gameObjects = Scene.getActivedGameObjects();
		if (!gameObjects.isEmpty()) {
			gameObjects.forEach(go -> {
				Graphs.paint(g, go);
			});

		}

	}

}
