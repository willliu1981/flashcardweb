package gameobjectimpl.component;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Component {
	private String owner;
	private String name;
	private Point relevantPosition;
	private Point absolutePosition;
	private Component parentComponent;
	private List<Component> components = new ArrayList<>();
	private String parentLayer;
	private Integer layer;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	


	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getParentLayer() {
		return parentLayer;
	}

	public void setParentLayer(String parentLayer) {
		this.parentLayer = parentLayer;
	}

	public Integer getLayer() {
		return layer;
	}

	public void setLayer(Integer layer) {
		this.layer = layer;
	}

	public Component getParentComponent() {
		return parentComponent;
	}

	public void setParentComponent(Component parentComponent) {
		this.parentComponent = parentComponent;
	}

	public Point getRelevantPosition() {
		return relevantPosition;
	}

	public void setRelevantPosition(Point relevantPosition) {
		this.relevantPosition = relevantPosition;
	}

	public void setPosition(String position) {
		String[] posArray = position.split(",");
		Point p = new Point();
		p.x = Integer.valueOf(posArray[0]);
		p.y = Integer.valueOf(posArray[1]);
		this.relevantPosition = p;
	}

	public Point getAbsolutePosition() {
		return absolutePosition;
	}

	public void setAbsolutePosition(Point absolutePosition) {
		this.absolutePosition = absolutePosition;
	}

	public List<Component> getComponents() {
		return components;
	}

	public void addComponent(Component component) {
		this.components.add(component);
		component.setParentComponent(this);
		Scene.addGameObject(component);
	}

	public void setAddComponent(List<Component> components) {
		components.forEach(comp -> {
			addComponent(comp);
		});
	}

	@Override
	public String toString() {
		return "Component [name=" + name + ", relevantPosition=" + relevantPosition
				+ ", absolutePosition=" + absolutePosition + ", parentComponent="
				+ parentComponent + ", components'size=" + components.size()
				+ ", layer=" + parentLayer + ":" + layer + "]";
	}

}
