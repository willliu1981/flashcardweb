package test6;

public class BeanProperty {
	public static final String BASE = "base";
	public static final String CLASS = "class";

	private String name;
	private Object value;
	private String valueType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

}
