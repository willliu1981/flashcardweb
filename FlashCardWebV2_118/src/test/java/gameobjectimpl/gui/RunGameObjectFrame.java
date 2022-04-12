package gameobjectimpl.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gameobjectimpl.component.Scene;

public class RunGameObjectFrame extends JFrame {

	private JPanel contentPane;
	private JPanel gameObjectPanel;

	/**
	 * Create the frame.
	 */
	public RunGameObjectFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1900, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		gameObjectPanel = new RunGameObjectPanel();
		contentPane.add(gameObjectPanel, BorderLayout.CENTER);
	}

	public JPanel getGameObjectPanel() {
		return gameObjectPanel;
	}

}
