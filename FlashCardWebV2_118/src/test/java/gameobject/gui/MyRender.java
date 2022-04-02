package gameobject.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

import gameobject.component.Component;

public class MyRender   implements ListCellRenderer<Component> {
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

	@Override
	public java.awt.Component getListCellRendererComponent(
			JList<? extends Component> list, Component value, int index,
			boolean isSelected, boolean cellHasFocus) {
		JLabel lbl = (JLabel) defaultRenderer.getListCellRendererComponent(list, value,
				index, isSelected, cellHasFocus);
		//JLabel lbl=new JLabel();
		// *
		//this.setLayout(new FlowLayout());
		//this.setFont(new Font(Font.SERIF, Font.ITALIC, 17));
		//this.setText("xxx");
		// list.setVisibleRowCount(30);
		// list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//*/
		//lbl.setBackground(Color.red);
		lbl.setFont(new Font(Font.SERIF, Font.ITALIC, 28));
		if(lbl.getGraphics()!=null) {
			lbl.setText("xxx");
			
		}
		return lbl;
	}

}
