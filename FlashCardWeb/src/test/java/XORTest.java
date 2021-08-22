import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class XORTest extends JFrame {
	static XORTest f;
	JLabel lblLayoutMask;
	static int layoutMask;
	static final int maxLayers = 32;
	static final int[] layers = new int[maxLayers];
	static {
		for (int i = 0; i < maxLayers; i++) {
			layers[i] = (int) Math.pow(2, i);
		}
	}

	class MyActionListener implements ActionListener {
		int layer;

		public MyActionListener(int layer) {
			this.layer = layer;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("action:" + layers[layer]);
			layoutMask ^= layers[layer];
			lblLayoutMask.setText(":" + layoutMask);
			f.pack();
		}

	}

	public static void main(String[] args) {
		f = new XORTest();
		f.init();
		f.pack();

	}

	void init() {
		this.setBounds(400, 0, 0, 0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		this.setLayout(new BorderLayout());

		initCenter();
		initEast();

	}

	void initCenter() {
		JPanel root = new JPanel();
		this.add(root, BorderLayout.CENTER);

		root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));

		for (int i = 0; i < maxLayers; i++) {
			JPanel p = new JPanel();
			root.add(p);

			p.setLayout(new FlowLayout());
			p.add(new JLabel("" + i));

			JCheckBox chk = new JCheckBox();
			p.add(chk);

			chk.addActionListener(new MyActionListener(i));
		}
	}

	void initEast() {
		JPanel root = new JPanel();
		this.add(root, BorderLayout.EAST);

		root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));

		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		root.add(p);
		p.add(new JLabel("layoutMask"));
		p.add(lblLayoutMask = new JLabel());

	}

}
