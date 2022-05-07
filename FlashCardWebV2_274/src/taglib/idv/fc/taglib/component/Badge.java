package idv.fc.taglib.component;

import idv.fc.taglib.component.listgroup.CommonComponent;

public class Badge extends CommonComponent {

	public Badge() {
		this.addHtmlClass("badge");
	}

	public Badge(String overridePrimeClass) {
		this.addHtmlClass(overridePrimeClass);
	}

}
