package gameobjectimpl.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.animator.Animator.KeyFrame;
import gameobjectimpl.component.ComponentAdapter;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.Scene;
import gameobjectimpl.component.impl.Person;
import gameobjectimpl.tool.AdapterListConverter;
import gameobjectimpl.tool.Animators;
import gameobjectimpl.tool.Components;
import gameobjectimpl.tool.GameObjectScanner;
import idv.tool.Debug;

public class PersonCreatorFrame extends JFrame {
	private GameObject target;
	private List<ComponentAdapter> adapters;

	private JPanel contentPane;
	private JList<ComponentAdapter> list;
	private JLabel lbl_keyIndex;

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
		setBounds(100, 100, 840, 789);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		CreatePersonGameObjectPanel pane_person_info = new CreatePersonGameObjectPanel();
		/*
		 * #mouse pressed
		 */
		pane_person_info.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ComponentAdapter adpt = list.getSelectedValue();
				Point adptP = e.getPoint();
				Point parentP = adpt.getParentComponent().getAbsolutePosition();
				Point relativeP = new Point();
				relativeP.setLocation(adptP.x - parentP.x, adptP.y - parentP.y);
				adpt.setRelevantPosition(relativeP);

				Animator anm = ((Person) target).getAnimator();

				KeyFrame key = new KeyFrame();
				key.setKeyName(adpt.getName());
				key.setKeyIndex(Integer.valueOf(lbl_keyIndex.getText()));
				key.setPosition(relativeP);
				anm.addKeyFrame(key);

				Debug.test(this, key.getKeyName());

				new Scene().locating();
				repaint();

			}
		});
		pane_person_info.setComponents(adapters);
		pane_person_info.setPerson(target);
		pane_person_info.setFrameIndex(0);
		contentPane.add(pane_person_info, BorderLayout.CENTER);

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

		list = new JList<>();
		list.addMouseListener(new MouseAdapter() {

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

		JButton btn_refresh = new JButton("refresh");
		btn_refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_refresh.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_east_bar.add(btn_refresh);

		JPanel panel_north_bar = new JPanel();
		contentPane.add(panel_north_bar, BorderLayout.NORTH);

		JPanel panel_south_bar = new JPanel();
		contentPane.add(panel_south_bar, BorderLayout.SOUTH);
		panel_south_bar.setLayout(new BorderLayout(0, 0));

		JPanel panel_scroll = new JPanel();
		panel_south_bar.add(panel_scroll);

		JButton btnNewButton_2_2 = new JButton("<");
		btnNewButton_2_2.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_scroll.add(btnNewButton_2_2);

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(120, 40));
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_scroll.add(panel_2);

		lbl_keyIndex = new JLabel("0");
		lbl_keyIndex.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_2.add(lbl_keyIndex);

		JButton btnNewButton_2 = new JButton(">");
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_scroll.add(btnNewButton_2);

		JPanel panel = new JPanel();
		panel_south_bar.add(panel, BorderLayout.EAST);

		JButton btnNewButton_1 = new JButton("Output");
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person person = (Person) Scene.findSceneComponent("David");

				Animators.write(person.getAnimator(), "David");
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 28));
	}

	public GameObject getTarget() {
		return target;
	}

	private void setTarget(GameObject target) {
		this.target = target;
	}

}
