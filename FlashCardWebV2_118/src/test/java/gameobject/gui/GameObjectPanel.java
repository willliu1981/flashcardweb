package gameobject.gui;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import gameobject.Component;
import gameobject.Scene;
import gameobject.tool.Graphs;

public class GameObjectPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GameObjectPanel() {

	}

	@Override
	public void paint(Graphics g) {

		List<Component> gameObjects = Scene.getGameObjects();
		gameObjects.forEach(go -> {
			Graphs.paint(g, go);
		});

	}

}
