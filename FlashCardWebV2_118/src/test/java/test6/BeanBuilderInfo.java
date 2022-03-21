package test6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BeanBuilderInfo {

	private String id;
	private String clazz;

	private List<BeanProperty> properties = new ArrayList<>();

	public void setBaseProperty(String name, Object value) {
		BaseProperty property = new BaseProperty();
		property.setName(name);
		property.setValue(value);
		property.setValueType(BeanProperty.BASE);
		this.properties.add(property);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassString() {
		return clazz;
	}

	public void setClassString(String clazz) {
		this.clazz = clazz;
	}

	public List<BeanProperty> getProperties() {
		return properties;
	}

}
