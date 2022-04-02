package gameobject.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import gameobject.component.Component;
import gameobject.component.GameObject;
import gameobject.gui.test.Book;
import gameobject.tool.GameObjectScanner;
import idv.tool.Debug;
import javax.swing.ListSelectionModel;

public class PersonCreatorFrame extends JFrame {
	private GameObject target;

	private JPanel contentPane;

	public PersonCreatorFrame(GameObject target) {
		this.setTarget(target);
		this.init();
	}

	/**
	 * Create the frame.
	 */
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		GameObjectPanel gameObjectPanel = new CreatePersonGameObjectPanel();
		contentPane.add(gameObjectPanel, BorderLayout.CENTER);

		JPanel panel_east_bar = new JPanel();
		contentPane.add(panel_east_bar, BorderLayout.EAST);
		panel_east_bar.setLayout(new BoxLayout(panel_east_bar, BoxLayout.Y_AXIS));

		//*
		final DefaultListModel<Component> model = new DefaultListModel<>();
		List<Component> components = GameObjectScanner.findComponents(target);
		components.forEach(comp -> {
			model.addElement(comp);
		});

		JList<Component> list = new JList<>();
		list.setFont(new Font("新細明體", Font.PLAIN, 28));
		list.setModel(model);
		list.setCellRenderer(new MyRender());
		//*/

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		panel_east_bar.add(scrollPane);

		JButton btnNewButton = new JButton("set");
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_east_bar.add(btnNewButton);
	}

	public GameObject getTarget() {
		return target;
	}

	private void setTarget(GameObject target) {
		this.target = target;
	}

}
