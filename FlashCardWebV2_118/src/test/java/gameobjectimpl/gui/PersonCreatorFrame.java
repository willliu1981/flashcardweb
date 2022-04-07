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
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.animator.Animator.KeyFrame;
import gameobjectimpl.component.ComponentAdapter;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.HasAnimation;
import gameobjectimpl.component.Scene;
import gameobjectimpl.component.impl.Person;
import gameobjectimpl.tool.AdapterListConverter;
import gameobjectimpl.tool.Animators;
import gameobjectimpl.tool.Components;
import gameobjectimpl.tool.GameObjectScanner;

public class PersonCreatorFrame extends JFrame {
	private static String TESTANIMATORNAME = "walk_right";
	private Timer tmr;
	private boolean tmrIsRunning = false;
	private GameObject target;
	private List<ComponentAdapter> adapters;

	private JPanel contentPane;
	private JList<ComponentAdapter> list;
	private JLabel lbl_keyIndex;
	private JTextField text_maxNumberOfKey;
	private JLabel lbl_animatorName;
	private String currentAnimatorName;
	private boolean currentAnimatorIsExist = false;

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
		pane_person_info.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (currentAnimatorIsExist) {
					if (list.getSelectedIndex() == -1) {
						return;
					}

					ComponentAdapter adpt = list.getSelectedValue();
					Point adptP = e.getPoint();
					Point parentP = adpt.getParentComponent().getAbsolutePosition();
					Point relativeP = new Point();
					relativeP.setLocation(adptP.x - parentP.x, adptP.y - parentP.y);
					adpt.setRelevantPosition(relativeP);

					Animator anm = ((Person) target).getAnimator(currentAnimatorName);

					KeyFrame key = new KeyFrame();
					key.setKeyName(adpt.getName());
					key.setKeyIndex(Integer.valueOf(lbl_keyIndex.getText()));
					key.setPosition(relativeP);
					anm.addKeyFrame(key);

					Scene.locating();
					repaint();
				}

			}
		});
		pane_person_info.setComponents(adapters);
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
				if (currentAnimatorIsExist) {
					JList<ComponentAdapter> source = (JList<ComponentAdapter>) e
							.getSource();
					ComponentAdapter selectedValue = (ComponentAdapter) source
							.getSelectedValue();

					Components.clearSelected(adapters);
					selectedValue.setSelected();
					repaint();
				}
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

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new LineBorder(Color.ORANGE));
		panel_north_bar.add(menuBar);

		JMenu mnNewMenu = new JMenu("animator");
		mnNewMenu.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		{
			List<String> animatorNames = Animators
					.getAnimatorNames((HasAnimation) target);

			animatorNames.forEach(n -> {
				JMenuItem mntmNewMenuItem = new JMenuItem(n);
				mntmNewMenuItem
						.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
				mnNewMenu.add(mntmNewMenuItem);
				mntmNewMenuItem.setName(n);
				mntmNewMenuItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JMenuItem item = (JMenuItem) e.getSource();

						loadAnimatorAndInit(item);
					}

				});
			});
		}

		JPanel panel = new JPanel();
		panel_north_bar.add(panel);

		lbl_animatorName = new JLabel("尚未選取");
		lbl_animatorName.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel.add(lbl_animatorName);

		JLabel lbl_animatorName_gap1 = new JLabel("      ");
		lbl_animatorName_gap1.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel.add(lbl_animatorName_gap1);

		JButton btn_output = new JButton("Output");
		panel_north_bar.add(btn_output);
		btn_output.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentAnimatorIsExist) {
					Person person = (Person) Scene.findSceneComponent("person1");
					person.getAnimator(currentAnimatorName).setMaxNumberOfKey(
							Integer.valueOf(text_maxNumberOfKey.getText().trim()));
					Animators.writeAll(person, person.getOwner());
				}
			}
		});
		btn_output.setFont(new Font("新細明體", Font.PLAIN, 28));

		JButton btn_reset = new JButton("Reset");
		btn_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*	Animators.reset();
				
					Person person = Application.getBean("defaultPerson1", Person.class);
					Scene.addSceneComponent(person);
				
					Animators.setPosture(person, 0);
					Scene.locating();
				
					PersonCreatorFrame pcf = new PersonCreatorFrame(person);
					pcf.setVisible(true);
				
					dispose();*/

			}
		});
		btn_reset.setForeground(Color.RED);
		btn_reset.setFont(new Font("新細明體", Font.BOLD, 28));
		panel_north_bar.add(btn_reset);

		JPanel panel_south_bar = new JPanel();
		contentPane.add(panel_south_bar, BorderLayout.SOUTH);
		panel_south_bar.setLayout(new BorderLayout(0, 0));

		JPanel panel_scroll_bar = new JPanel();
		panel_south_bar.add(panel_scroll_bar);

		JButton btn_previous = new JButton("<");
		btn_previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentAnimatorIsExist) {
					int index = -1;
					if ((index = Integer.valueOf(lbl_keyIndex.getText().trim())) <= 0) {
						index = target.getAnimator(currentAnimatorName)
								.getMaxNumberOfKey();
					} else {
						index--;
					}
					lbl_keyIndex.setText("" + index);

					refreshPosture();
				}
			}
		});
		btn_previous.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_scroll_bar.add(btn_previous);

		JPanel panel_keyIndex = new JPanel();
		panel_keyIndex.setPreferredSize(new Dimension(80, 40));
		panel_keyIndex.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_scroll_bar.add(panel_keyIndex);

		lbl_keyIndex = new JLabel("0");
		lbl_keyIndex.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_keyIndex.add(lbl_keyIndex);

		JButton btn_next = new JButton(">");
		btn_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentAnimatorIsExist) {
					int index = Integer.valueOf(lbl_keyIndex.getText().trim());
					if (index >= Integer
							.valueOf(text_maxNumberOfKey.getText().trim())) {
						index = 0;
					} else {
						index++;
					}
					lbl_keyIndex.setText("" + index);

					refreshPosture();
				}
			}
		});
		btn_next.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_scroll_bar.add(btn_next);

		JPanel panel_output = new JPanel();
		panel_south_bar.add(panel_output, BorderLayout.EAST);

		JButton btn_test = new JButton("Test");
		btn_test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentAnimatorIsExist) {
					if (tmrIsRunning == true) {
						tmr.cancel();
						tmrIsRunning = false;
						return;
					}

					tmr = new Timer();

					TimerTask task = new TimerTask() {
						int index;

						@Override
						public void run() {
							Animators.setPosture((HasAnimation) target,currentAnimatorName, index);
							Scene.locating();
							repaint();

							index++;
							if (index > target.getAnimator(currentAnimatorName)
									.getMaxNumberOfKey()) {
								index = 0;
							}
						}
					};

					tmr.schedule(task, 500, 200);
					tmrIsRunning = true;
				}
			}
		});
		btn_test.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_output.add(btn_test);

		JPanel panel_maxKey = new JPanel();
		panel_south_bar.add(panel_maxKey, BorderLayout.WEST);

		JLabel lbl_maxNumber = new JLabel("max number of key");
		lbl_maxNumber.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_maxKey.add(lbl_maxNumber);

		text_maxNumberOfKey = new JTextField();
		text_maxNumberOfKey.setHorizontalAlignment(SwingConstants.CENTER);
		text_maxNumberOfKey.setText("" + 0);
		text_maxNumberOfKey.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_maxKey.add(text_maxNumberOfKey);
		text_maxNumberOfKey.setColumns(3);
	}

	protected void loadAnimatorAndInit(JMenuItem item) {
		String name = item.getName();
		lbl_animatorName.setText(name);
		currentAnimatorName = name;
		this.text_maxNumberOfKey.setText("" + ((HasAnimation) target)
				.getAnimator(currentAnimatorName).getMaxNumberOfKey());
		this.lbl_keyIndex.setText("" + 0);
		currentAnimatorIsExist = true;

		this.refreshPosture();
	}

	protected int getKeyIndexFromLabel() {
		return Integer.valueOf(lbl_keyIndex.getText().trim());
	}

	protected int getMaxNumberOfKeyFromText() {
		return Integer.valueOf(text_maxNumberOfKey.getText().trim());
	}

	protected void refreshPosture() {
		Animators.setPosture((HasAnimation) target,currentAnimatorName, this.getKeyIndexFromLabel());
		repaint();
	}

	public GameObject getTarget() {
		return target;
	}

	private void setTarget(GameObject target) {
		this.target = target;
	}

}