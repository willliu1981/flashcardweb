package gameobject.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gameobject.Scene;

public class GameObjectFrame extends JFrame {

	private JPanel contentPane;
	private static  Scene scene;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameObjectFrame frame = new GameObjectFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	public static Scene getScene() {
		return scene;
	}



	public static void setScene(Scene scene) {
		GameObjectFrame.scene = scene;
	}



	/**
	 * Create the frame.
	 */
	public GameObjectFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		GameObjectPanel gameObjectPanel = new GameObjectPanel();
		contentPane.add(gameObjectPanel, BorderLayout.CENTER);
	}

}
