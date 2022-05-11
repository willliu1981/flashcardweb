package idv.taglib.component.listgroup;

import idv.taglib.component.common.CommonComponentItem;

public class ListGroupItemText extends CommonComponentItem {

	public ListGroupItemText() {
		this.addHtmlClass("list-group-item-text");
		this.setHtmlTag("span");
	}

	public ListGroupItemText(String overridePrimeClass) {
		this.addHtmlClass(overridePrimeClass);
	}
}
