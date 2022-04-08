package gameobjectimpl.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import gameobjectimpl.component.ComponentAdapter;
import gameobjectimpl.component.Scene;
import gameobjectimpl.tool.Graphs;

public class CreatePersonGameObjectPanel extends JPanel {

	private List<ComponentAdapter> adapters;
	private boolean showPrevious = false;

	public CreatePersonGameObjectPanel() {
		setBorder(new LineBorder(Color.CYAN));

	}

	public boolean isShowPrevious() {
		return showPrevious;
	}

	public void setShowPrevious(boolean createMode) {
		this.showPrevious = createMode;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		if (adapters != null && !adapters.isEmpty()) {
			Scene.locating();
			if (isShowPrevious()) {
				Graphs.paintForCreatePersonPrevious(g, adapters);
			}
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
