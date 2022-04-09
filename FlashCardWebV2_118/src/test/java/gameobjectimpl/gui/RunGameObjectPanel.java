package gameobjectimpl.gui;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import gameobjectimpl.component.Component;
import gameobjectimpl.component.Scene;
import gameobjectimpl.tool.Graphs;
import idv.tool.Debug;

import javax.swing.border.LineBorder;
import java.awt.Color;

public class RunGameObjectPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public RunGameObjectPanel() {
		setBorder(new LineBorder(Color.CYAN));

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		

		Scene.locating();
		Scene.paintActivedGameObjects(g);

	}

}
