package gameobjectimpl.gui.test;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class TestRender implements ListCellRenderer<Book> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Book> list,
			Book value, int index, boolean isSelected, boolean cellHasFocus) {

		JLabel label = new JLabel();
		label.setText(value.getName());
		return label;
	}

}
