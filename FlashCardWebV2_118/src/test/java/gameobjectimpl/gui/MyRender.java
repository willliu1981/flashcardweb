package gameobjectimpl.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

import gameobjectimpl.component.Component;
import idv.tool.Debug;

public class MyRender extends JPanel implements ListCellRenderer<Component> {
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
	private JLabel lbIcon = new JLabel();
	private JLabel lbName = new JLabel();
	private JLabel lbComponentCount = new JLabel();

	public MyRender() {
		setLayout(new BorderLayout(5, 5));

		JPanel panelText = new JPanel(new GridLayout(1, 0));
		this.lbName.setFont(new Font(Font.SERIF, Font.ITALIC, 28));
		this.lbComponentCount.setFont(new Font(Font.SERIF, Font.ITALIC, 28));
		panelText.add(lbName);
		panelText.add(lbComponentCount);
		add(lbIcon, BorderLayout.WEST);
		add(panelText, BorderLayout.CENTER);
	}

	@Override
	public java.awt.Component getListCellRendererComponent(
			JList<? extends Component> list, Component value, int index,
			boolean isSelected, boolean cellHasFocus) {

		this.lbName.setText(value.getName());
		this.lbComponentCount
				.setText(String.format(" (%d)", value.getComponents().size()));

		lbName.setOpaque(true);
		lbComponentCount.setOpaque(true);
		lbIcon.setOpaque(true);

		if (isSelected) {
			lbName.setBackground(list.getSelectionBackground());
			lbComponentCount.setBackground(list.getSelectionBackground());
			lbIcon.setBackground(list.getSelectionBackground());
			setBackground(list.getSelectionBackground());
		} else { // when don't select
			lbName.setBackground(list.getBackground());
			lbComponentCount.setBackground(list.getBackground());
			lbIcon.setBackground(list.getBackground());
			setBackground(list.getBackground());
		}
		return this;
	}

}
