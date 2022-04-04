package gameobjectimpl.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import gameobjectimpl.component.ComponentAdapter;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.Scene;
import gameobjectimpl.component.impl.Person;
import gameobjectimpl.tool.AdapterListConverter;
import gameobjectimpl.tool.Animators;
import gameobjectimpl.tool.Components;
import gameobjectimpl.tool.GameObjectScanner;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PersonCreatorFrame extends JFrame {
	private GameObject target;
	private List<ComponentAdapter> adapters;

	private JPanel contentPane;

	public PersonCreatorFrame(GameObject target) {
		this.setTarget(target);
		this.adapters = AdapterListConverter.convert(
				GameObjectScanner.findComponents(target), ComponentAdapter.class);

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

		CreatePersonGameObjectPanel panelinfo_pserson = new CreatePersonGameObjectPanel();
		panelinfo_pserson.setComponents(adapters);
		panelinfo_pserson.setPerson(target);
		panelinfo_pserson.setFrameIndex(0);
		contentPane.add(panelinfo_pserson, BorderLayout.CENTER);

		JPanel panel_east_bar = new JPanel();
		contentPane.add(panel_east_bar, BorderLayout.EAST);
		panel_east_bar.setLayout(new BoxLayout(panel_east_bar, BoxLayout.Y_AXIS));

		//*
		final DefaultListModel<ComponentAdapter> model = new DefaultListModel<>();

		adapters = adapters.stream()
				.sorted(Comparator.comparing(ComponentAdapter::getLayer))
				.collect(Collectors.toList());

		adapters.forEach(comp -> {
			model.addElement(comp);
		});

		JList<ComponentAdapter> list = new JList<>();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				@SuppressWarnings("unchecked")
				JList<ComponentAdapter> source = (JList<ComponentAdapter>) e
						.getSource();
				ComponentAdapter selectedValue = (ComponentAdapter) source
						.getSelectedValue();

				Components.clearSelected(adapters);
				selectedValue.setSelected();
				repaint();
			}
		});
		list.setFont(new Font("新細明體", Font.PLAIN, 28));
		list.setModel(model);
		list.setCellRenderer(new MyRender());
		//*/

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		panel_east_bar.add(scrollPane);

		JButton btnNewButton = new JButton("set");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_east_bar.add(btnNewButton);

		JPanel panel_north_bar = new JPanel();
		contentPane.add(panel_north_bar, BorderLayout.NORTH);

		JButton btnNewButton_1 = new JButton("Output");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person person = (Person) Scene.findSceneComponent("David");

				Animators.write(person.getAnimator(), "David");
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_north_bar.add(btnNewButton_1);

		JPanel panel_south_bar = new JPanel();
		contentPane.add(panel_south_bar, BorderLayout.SOUTH);

		JButton btnNewButton_2 = new JButton("<");
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_south_bar.add(btnNewButton_2);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setPreferredSize(new Dimension(120, 40));
		panel_south_bar.add(panel);

		JLabel lblNewLabel = new JLabel("0");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 28));

		JButton btnNewButton_2_1 = new JButton(">");
		btnNewButton_2_1.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_south_bar.add(btnNewButton_2_1);
	}

	public GameObject getTarget() {
		return target;
	}

	private void setTarget(GameObject target) {
		this.target = target;
	}

}
