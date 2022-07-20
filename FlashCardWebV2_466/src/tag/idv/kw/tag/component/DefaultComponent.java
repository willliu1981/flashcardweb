package idv.kw.tag.component;

import idv.kw.tag.itf.ComponentAdapter;

public class DefaultComponent extends ComponentAdapter {

	public DefaultComponent() {
	}

	public DefaultComponent(String tag) {
		this.setHtmlTag(tag);
	}

}
