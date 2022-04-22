package idv.simplegame.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DemoGame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoGame frame = new DemoGame();
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
	int count;
	private JLabel lbl_add;

	public DemoGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Click");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_add.setText("" + count++);
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 28));
		contentPane.add(btnNewButton, BorderLayout.NORTH);

		lbl_add = new JLabel("New label");
		lbl_add.setFont(new Font("新細明體", Font.PLAIN, 28));
		lbl_add.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl_add, BorderLayout.CENTER);
	}

}
