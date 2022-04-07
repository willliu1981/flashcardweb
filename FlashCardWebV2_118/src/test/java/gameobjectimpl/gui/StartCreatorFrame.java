package gameobjectimpl.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gameobjectimpl.animator.AnimatorBuilder;
import gameobjectimpl.component.Scene;
import gameobjectimpl.component.impl.Person;
import gameobjectimpl.config.Application;
import gameobjectimpl.tool.Animators;
import idv.tool.Debug;
import idv.tool.spring.MySpringUtil;

public class StartCreatorFrame extends JFrame {
	private static String TESTANIMATORNAME = "walk_right";
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartCreatorFrame frame = new StartCreatorFrame();
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
	public StartCreatorFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Create Pserson");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean fileIsExist = Animators.fileIsExist();
				Person person = null;

				if (fileIsExist) {
					person = Application.getBean("person1", Person.class);
				} else {
					Animators.createEmptyFile();
					person = Application.getBean("defaultPerson1", Person.class);
					Animators.write(person.getAnimator(TESTANIMATORNAME),
							person.getOwner());
				}

				Scene.addSceneComponent(person);

				PersonCreatorFrame pcf = new PersonCreatorFrame(person);
				pcf.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 28));
		contentPane.add(btnNewButton, BorderLayout.CENTER);
	}

}
