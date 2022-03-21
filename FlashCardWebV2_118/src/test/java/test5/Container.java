package test5;

import java.util.ArrayList;
import java.util.List;

public class Container {
	private Object value;
	private List<Container> subCont=new ArrayList<>();

	public Container() {
		
	}
	
	public Container(Object value) {
		super();
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	public void setProperty(Container cont) {
		this.subCont.add(cont);
	}

}
