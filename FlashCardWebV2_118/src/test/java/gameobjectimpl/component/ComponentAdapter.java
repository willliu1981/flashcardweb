package gameobjectimpl.component;

import java.awt.Point;
import java.util.List;

import gameobjectimpl.Animator;
import gameobjectimpl.adapter.AdapterI;

public class ComponentAdapter extends Component implements AdapterI<Component> {

	private Component comp;


	private boolean selected = false;


	public void setSelected() {
		this.selected = true;
	}

	public void setSelected(boolean res) {
		this.selected = res;
	}

	public boolean isSelected() {
		return selected;
	}

	public Point getAbsolutePosition() {
		return comp.getAbsolutePosition();
	}

	public String getName() {
		return comp.getName();
	}

	public void setName(String name) {
		comp.setName(name);
	}

	public String getOwner() {
		return comp.getOwner();
	}

	public void setOwner(String owner) {
		comp.setOwner(owner);
	}

	public String getParentLayer() {
		return comp.getParentLayer();
	}

	public void setParentLayer(String parentLayer) {
		comp.setParentLayer(parentLayer);
	}

	public Integer getLayer() {
		return comp.getLayer();
	}

	public void setLayer(Integer layer) {
		comp.setLayer(layer);
	}

	public Component getParentComponent() {
		return comp.getParentComponent();
	}

	public void setParentComponent(Component parentComponent) {
		comp.setParentComponent(parentComponent);
	}

	public Point getRelevantPosition() {
		return comp.getRelevantPosition();
	}

	public void setRelevantPosition(Point relevantPosition) {
		comp.setRelevantPosition(relevantPosition);
	}

	public void setPosition(String position) {
		comp.setPosition(position);
	}

	public int hashCode() {
		return comp.hashCode();
	}

	public void setAbsolutePosition(Point absolutePosition) {
		comp.setAbsolutePosition(absolutePosition);
	}

	public List<Component> getComponents() {
		return comp.getComponents();
	}

	public void addComponent(Component component) {
		comp.addComponent(component);
	}

	public void setAddComponent(List<Component> components) {
		comp.setAddComponent(components);
	}

	public String toString() {
		return comp.toString();
	}

	public boolean equals(Object obj) {
		return comp.equals(obj);
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
