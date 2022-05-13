package idv.taglib.component.listgroup;

import idv.taglib.component.common.CommonComponent;

public class ListGroupItemText extends CommonComponent {

	public ListGroupItemText() {
		this.addHtmlClass("list-group-item-text");
		this.setHtmlTag("span");
	}

	public ListGroupItemText(String overridePrimeClass) {
		this.addHtmlClass(overridePrimeClass);
	}
}
