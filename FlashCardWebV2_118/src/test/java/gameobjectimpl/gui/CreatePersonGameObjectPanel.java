package gameobjectimpl.gui;

import java.awt.Graphics;
import java.util.List;

import gameobjectimpl.component.Component;
import gameobjectimpl.component.ComponentAdapter;
import gameobjectimpl.component.Scene;
import gameobjectimpl.tool.Graphs;

public class CreatePersonGameObjectPanel extends GameObjectPanel {

	private List<ComponentAdapter> components;

	/**
	 * Create the panel.
	 */
	public CreatePersonGameObjectPanel() {

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (!components.isEmpty()) {
			components.forEach(go -> {
				Graphs.paintForCreatePerson(g, go);

			});

		}

	}

	public List<ComponentAdapter> getGameObjectComponents() {
		return components;
	}

	public void setComponents(List<ComponentAdapter> components) {
		this.components = components;
	}

}
