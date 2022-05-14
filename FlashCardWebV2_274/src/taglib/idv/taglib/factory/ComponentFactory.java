package idv.taglib.factory;

import idv.taglib.component.common.impl.DefaultComponent;
import idv.taglib.component.itf.TaglibComponentItem;

public class ComponentFactory {

	public static TaglibComponentItem getDefaultComponent(String tag) {
		DefaultComponent defaultComponent = new DefaultComponent();
		defaultComponent.setHtmlTag(tag);
		return defaultComponent;
	}

}
