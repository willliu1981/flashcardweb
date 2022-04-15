package gameobjectimpl.gui.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

public class TestFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
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
	public TestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JList<Book> list = new JList<>();
		DefaultListModel<Book> model =new DefaultListModel<>();
		
		
		
		Book b1=new Book("Java",1200);
		Book b2=new Book("C#",1100);
		
		model.addElement(b1);
		model.addElement(b2);
		list.setModel(model);
		
		TestRender render=new TestRender();
		list.setCellRenderer(render);
		
		
		contentPane.add(list, BorderLayout.CENTER);
	}

}
