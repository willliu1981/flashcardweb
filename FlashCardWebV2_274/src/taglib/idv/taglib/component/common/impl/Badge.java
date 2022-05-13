package idv.taglib.component.common.impl;

import idv.taglib.component.common.CommonComponent;

public class Badge extends CommonComponent {

	public Badge() {
		this.addHtmlClass("badge");
		this.setHtmlTag("span");
	}

	public Badge(String overridePrimeClass) {
		this.addHtmlClass(overridePrimeClass);
	}

}
