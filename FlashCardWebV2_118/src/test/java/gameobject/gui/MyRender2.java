package gameobject.gui;

import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

import gameobject.gui.test.Book;

public class MyRender2 extends JLabel implements ListCellRenderer<Book> {
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

	@Override
	public java.awt.Component getListCellRendererComponent(JList<? extends Book> list,
			Book value, int index, boolean isSelected, boolean cellHasFocus) {
		//JLabel lbl = (JLabel) defaultRenderer.getListCellRendererComponent(list, value,
			//	index, isSelected, cellHasFocus);
		// JLabel lbl=new JLabel();
		// *
		// this.setLayout(new FlowLayout());
		// this.setFont(new Font(Font.SERIF, Font.ITALIC, 17));
		// this.setText("xxx");
		// list.setVisibleRowCount(30);
		// list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//*/
		// lbl.setBackground(Color.red);
		this.setFont(new Font(Font.SERIF, Font.ITALIC, 28));
		this.setText(value.getName());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


		return this;
	}

}
