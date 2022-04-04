package gameobjectimpl.gui;

import java.awt.Graphics;
import java.util.List;

import gameobjectimpl.component.ComponentAdapter;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.tool.Graphs;

public class CreatePersonGameObjectPanel extends GameObjectPanel {

	private List<ComponentAdapter> adapters;

	/**
	 * Create the panel.
	 */
	public CreatePersonGameObjectPanel() {

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (!adapters.isEmpty()) {
			Graphs.paintForCreatePerson(g, adapters);

		}

	}

	public List<ComponentAdapter> getGameObjectComponents() {
		return adapters;
	}

	public void setComponents(List<ComponentAdapter> components) {
		this.adapters = components;
	}

}
