package idv.kw.tag.factory;

import idv.kw.tag.component.DefaultComponent;

public class TagBuilder{

	public static DefaultComponent createDefaultComponent(String tag) {
		return new DefaultComponent(tag);
	}
	
	
	
	
}
