package idv.fc.taglib.component.common;

public class Badge extends CommonComponentItem {

	public Badge() {
		this.addHtmlClass("badge");
		this.setHtmlTag("span");
	}

	public Badge(String overridePrimeClass) {
		this.addHtmlClass(overridePrimeClass);
	}

}
