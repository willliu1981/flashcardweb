package gameobjectimpl.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.component.HasAnimation;
import gameobjectimpl.tool.Frames;

public class AddAnimatorFrame extends JFrame {
	private ParentContainer parentContainer;
	private HasAnimation parentAnimator;
	private JPanel contentPane;
	private JTextField txt_name;

	/**
	 * Create the frame.
	 */
	public AddAnimatorFrame(ParentContainer parentContainer) {
		this.parentContainer = parentContainer;

		init();
	}

	public void init() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Frames.setBoundsCenterToParentContainer(this.parentContainer, this, 500, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btn_confirm = new JButton("confirm");
		btn_confirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String name = txt_name.getText();
				Animator anm = new Animator();
				anm.setName(name);
				getParentAnimator().addAnimator(name, anm);
				parentContainer.restart();
			}
		});
		btn_confirm.setFont(new Font("新細明體", Font.PLAIN, 28));
		contentPane.add(btn_confirm, BorderLayout.SOUTH);

		JPanel panel_inf = new JPanel();
		contentPane.add(panel_inf, BorderLayout.CENTER);
		panel_inf.setLayout(new BorderLayout(0, 0));

		JLabel lbl_inf = new JLabel("Create an animator");
		lbl_inf.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_inf.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_inf.add(lbl_inf);

		JPanel panel_name = new JPanel();
		panel_inf.add(panel_name, BorderLayout.SOUTH);

		txt_name = new JTextField();
		txt_name.setHorizontalAlignment(SwingConstants.CENTER);
		txt_name.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_name.add(txt_name);
		txt_name.setColumns(20);
	}

	public HasAnimation getParentAnimator() {
		return parentAnimator;
	}

	public void setParentAnimator(HasAnimation parentAnimator) {
		this.parentAnimator = parentAnimator;
	}

}
