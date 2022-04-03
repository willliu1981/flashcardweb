package gameobject.gui;

import java.awt.Graphics;
import java.util.List;

import gameobject.component.Component;
import gameobject.component.Scene;
import gameobject.interceptor.handler.MyHandler;
import gameobject.tool.Graphs;
import idv.fc.exception.FindErrorException;
import idv.fc.proxy.ProxyFactory;
import idv.fc.proxy.interceptor.Shuttle;

public class CreatePersonGameObjectPanel extends GameObjectPanel {

	/**
	 * Create the panel.
	 */
	public CreatePersonGameObjectPanel() {

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		List<Component> gameObjects = Scene.getGameObjects();
		if (!gameObjects.isEmpty()) {
			gameObjects.forEach(go -> {
				Graphs.paintForCreatePerson(g, go);

			});

		}

	}

}
