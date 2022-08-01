package idv.fc.model.dto.simpledto;

public class SimpleVO {
	String id;
	String value[];

	public SimpleVO(String id, String value[]) {
		super();
		this.id = id;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String[] getValue() {
		return value;
	}

	public void setValue(String[] value) {
		this.value = value;
	}

}
