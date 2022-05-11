package idv.taglib.component.common.impl;

import idv.taglib.component.common.CommonComponentItem;

public class Badge extends CommonComponentItem {

	public Badge() {
		this.addHtmlClass("badge");
		this.setHtmlTag("span");
	}

	public Badge(String overridePrimeClass) {
		this.addHtmlClass(overridePrimeClass);
	}

}
