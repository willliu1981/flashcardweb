package test.robot;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RobotDemoView extends JFrame {

	private JPanel contentPane;
	private JPanel panel_paint;
	Robot robot;
	private Canvas canvas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RobotDemoView frame = new RobotDemoView();
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
	public RobotDemoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel_paint = new JPanel();
		contentPane.add(panel_paint, BorderLayout.CENTER);
		panel_paint.setLayout(new BorderLayout(0, 0));
		
		canvas = new Canvas() {

			@Override
			public void paint(Graphics g) {
				Graphics2D g2d = (Graphics2D)g;
				if(robot!=null) {

					RobotFactory.paintRobot(robot);
				}
				
			}
			
		};
		panel_paint.add(canvas, BorderLayout.CENTER);

	}
	
	public void repaintRobot() {
		canvas.repaint();

	}

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

}
