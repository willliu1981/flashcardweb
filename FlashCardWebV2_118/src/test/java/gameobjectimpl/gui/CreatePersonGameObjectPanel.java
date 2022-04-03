package gameobjectimpl.gui;

import java.awt.Graphics;
import java.util.List;

import gameobjectimpl.component.ComponentAdapter;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.tool.Graphs;

public class CreatePersonGameObjectPanel extends GameObjectPanel {

	private List<ComponentAdapter> adapters;
	private Integer frameIndex=0;
	private GameObject person;

	/**
	 * Create the panel.
	 */
	public CreatePersonGameObjectPanel() {

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (!adapters.isEmpty()) {
			Graphs.paintForCreatePerson(g, adapters, person,frameIndex);

		}

	}

	public GameObject getPerson() {
		return person;
	}

	public void setPerson(GameObject person) {
		this.person = person;
	}

	public List<ComponentAdapter> getGameObjectComponents() {
		return adapters;
	}

	public void setComponents(List<ComponentAdapter> components) {
		this.adapters = components;
	}

	public Integer getFrameIndex() {
		return frameIndex;
	}

	public void setFrameIndex(Integer frameIndex) {
		this.frameIndex = frameIndex;
	}

}
