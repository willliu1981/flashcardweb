package idv.taglib.factory;

import idv.taglib.component.common.impl.DefaultComponent;
import idv.taglib.component.itf.TaglibComponentItem;

public class ComponentFactory {

	public static TaglibComponentItem getDefaultComponent(String tag) {
		return new DefaultComponent(tag);
	}

}
