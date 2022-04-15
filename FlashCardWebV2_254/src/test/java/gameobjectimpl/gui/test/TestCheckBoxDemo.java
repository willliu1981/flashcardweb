package gameobjectimpl.gui.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TestCheckBoxDemo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestCheckBoxDemo frame = new TestCheckBoxDemo();
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
	public TestCheckBoxDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		contentPane.add(chckbxNewCheckBox, BorderLayout.CENTER);
		scaleCheckBoxIcon(chckbxNewCheckBox);

	}

	public static void scaleCheckBoxIcon(JCheckBox checkbox) {
		boolean previousState = checkbox.isSelected();
		checkbox.setSelected(false);
		FontMetrics boxFontMetrics = checkbox.getFontMetrics(checkbox.getFont());
		Icon boxIcon = UIManager.getIcon("CheckBox.icon");
		BufferedImage boxImage = new BufferedImage(boxIcon.getIconWidth(),
				boxIcon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics graphics = boxImage.createGraphics();
		try {
			boxIcon.paintIcon(checkbox, graphics, 0, 0);
		} finally {
			graphics.dispose();
		}
		ImageIcon newBoxImage = new ImageIcon(boxImage);
		Image finalBoxImage = newBoxImage.getImage().getScaledInstance(
				boxFontMetrics.getHeight(), boxFontMetrics.getHeight(),
				Image.SCALE_SMOOTH);
		checkbox.setIcon(new ImageIcon(finalBoxImage));

		checkbox.setSelected(true);
		Icon checkedBoxIcon = UIManager.getIcon("test.png");
		BufferedImage checkedBoxImage = new BufferedImage(checkedBoxIcon.getIconWidth(),
				checkedBoxIcon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics checkedGraphics = checkedBoxImage.createGraphics();
		try {
			checkedBoxIcon.paintIcon(checkbox, checkedGraphics, 0, 0);
		} finally {
			checkedGraphics.dispose();
		}
		ImageIcon newCheckedBoxImage = new ImageIcon(checkedBoxImage);
		Image finalCheckedBoxImage = newCheckedBoxImage.getImage().getScaledInstance(
				boxFontMetrics.getHeight(), boxFontMetrics.getHeight(),
				Image.SCALE_SMOOTH);
		checkbox.setSelectedIcon(new ImageIcon(finalCheckedBoxImage));
		checkbox.setSelected(false);
		checkbox.setSelected(previousState);
	}

}
