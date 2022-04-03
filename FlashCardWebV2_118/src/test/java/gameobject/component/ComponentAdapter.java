package gameobject.component;

import java.awt.Point;

import gameobject.adapter.AdapterI;

public class ComponentAdapter extends Component implements AdapterI<Component> {

	private Component comp;

	private boolean selected = false;

	public void setSelected() {
		this.selected = true;
	}

	public boolean isSelected() {
		return selected;
	}

	public Point getAbsolutePosition() {
		return comp.getAbsolutePosition();
	}

	@Override
	public void setTarget(Component t) {
		this.comp = t;
	}

	@Override
	public Component getTarget() {
		return this.comp;
	}

}
