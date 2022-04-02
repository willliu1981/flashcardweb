package gameobject.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gameobject.component.Component;
import gameobject.component.GameObject;
import gameobject.component.impl.Person;
import gameobject.config.Application;
import idv.tool.spring.MySpringUtil;

public class PersonCreatorFrame extends JFrame {
	private GameObject target = Application.getPerson();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonCreatorFrame frame = new PersonCreatorFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PersonCreatorFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		GameObjectPanel gameObjectPanel = new GameObjectPanel();
		contentPane.add(gameObjectPanel, BorderLayout.CENTER);

		JPanel panel_east_bar = new JPanel();
		contentPane.add(panel_east_bar, BorderLayout.EAST);
		panel_east_bar.setLayout(new BoxLayout(panel_east_bar, BoxLayout.Y_AXIS));

		final DefaultListModel<Component> model = new DefaultListModel<>();
		List<Component> components = target.getComponents();
		components.forEach(comp -> {
			model.addElement(comp);
		});
		JList<Component> list = new JList<>(model);
		list.setFont(new Font("新細明體", Font.PLAIN, 28));

		//list.setModel(model);
		list.setCellRenderer(new MyRender());
		panel_east_bar.add(list);


		JButton btnNewButton = new JButton("set");
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_east_bar.add(btnNewButton);
	}

	public GameObject getTarget() {
		return target;
	}

	public void setTarget(GameObject target) {
		this.target = target;
	}

}
