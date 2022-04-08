package gameobjectimpl.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.tool.Animators;
import idv.tool.Debug;
import java.awt.GridLayout;

public class ReverseKeyFrame extends JFrame {
	private List<Animator> reverses;
	private List<Animator> targets;

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ReverseKeyFrame(List<Animator> anms) throws HeadlessException {
		super();

		this.reverses = anms;
		this.targets = anms;

		init();
	}

	public void init() {
		setTitle("reverse keys");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 709, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel_lists = new JPanel();
		contentPane.add(panel_lists, BorderLayout.CENTER);
		panel_lists.setLayout(new BoxLayout(panel_lists, BoxLayout.X_AXIS));

		JPanel panel_reverse = new JPanel();
		panel_lists.add(panel_reverse);
		panel_reverse.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_reverse = new JScrollPane();
		panel_reverse.add(scrollPane_reverse);

		DefaultListModel<Animator> model_reverse = new DefaultListModel<>();
		{
			this.reverses.forEach(anm -> model_reverse.addElement(anm));
		}
		JList<Animator> list_reverse = new JList<>();
		list_reverse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_reverse.setViewportView(list_reverse);
		list_reverse.setModel(model_reverse);
		list_reverse.setCellRenderer(new AnimatorRender());

		JPanel panel_sign = new JPanel();
		panel_sign.setPreferredSize(new Dimension(100, 10));
		panel_lists.add(panel_sign);
		panel_sign.setLayout(new BoxLayout(panel_sign, BoxLayout.Y_AXIS));

		JPanel panel_sign_inner = new JPanel();
		panel_sign.add(panel_sign_inner);
		panel_sign_inner.setLayout(new BoxLayout(panel_sign_inner, BoxLayout.X_AXIS));

		JLabel lbl_sign = new JLabel("⇒");
		panel_sign_inner.add(lbl_sign);
		lbl_sign.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sign.setFont(new Font("Cambria", Font.PLAIN, 40));

		JPanel panel_target = new JPanel();
		panel_lists.add(panel_target);
		panel_target.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_target = new JScrollPane();
		panel_target.add(scrollPane_target);

		DefaultListModel<Animator> model_target = new DefaultListModel<>();
		{
			this.targets.forEach(anm -> model_target.addElement(anm));
		}

		JList<Animator> list_target = new JList<>();
		list_target.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_target.setViewportView(list_target);
		list_target.setModel(model_target);
		list_target.setCellRenderer(new AnimatorRender());

		JPanel panel_confirm = new JPanel();
		contentPane.add(panel_confirm, BorderLayout.SOUTH);

		JButton btn_reverse = new JButton("Reverse");
		btn_reverse.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if (list_reverse.getSelectedValue().getName()
						.equals(list_target.getSelectedValue().getName())) {
					return;
				}

				Gson g = new Gson();
				String json1 = g.toJson(list_reverse.getSelectedValue());

				Animators.reverseKeys(list_reverse.getSelectedValue(),
						list_target.getSelectedValue());

				String json2 = g.toJson(list_reverse.getSelectedValue());
			}
		});
		panel_confirm.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblNewLabel = new JLabel("reverse anm.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_confirm.add(lblNewLabel);
		btn_reverse.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_confirm.add(btn_reverse);
		
		JLabel lblTargetAnm = new JLabel("target anm.");
		lblTargetAnm.setHorizontalAlignment(SwingConstants.CENTER);
		lblTargetAnm.setFont(new Font("新細明體", Font.PLAIN, 28));
		panel_confirm.add(lblTargetAnm);
	}

}
