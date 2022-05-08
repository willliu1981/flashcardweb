package idv.fc.taglib.component.common;

import idv.fc.taglib.component.listgroup.CommonComponentItem;

public class Badge extends CommonComponentItem {

	public Badge() {
		this.addHtmlClass("badge");
	}

	public Badge(String overridePrimeClass) {
		this.addHtmlClass(overridePrimeClass);
	}

}
