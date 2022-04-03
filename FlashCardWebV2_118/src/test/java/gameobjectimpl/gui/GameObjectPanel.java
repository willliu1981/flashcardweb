package gameobjectimpl.gui;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import gameobjectimpl.component.Component;
import gameobjectimpl.component.Scene;
import gameobjectimpl.tool.Graphs;

public class GameObjectPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GameObjectPanel() {

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		List<Component> gameObjects = Scene.getGameObjects();
		if (!gameObjects.isEmpty()) {
			gameObjects.forEach(go -> {
				Graphs.paint(g, go);
			});

		}

	}

}
