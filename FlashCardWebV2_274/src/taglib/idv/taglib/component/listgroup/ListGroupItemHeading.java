package idv.taglib.component.listgroup;

import idv.taglib.component.common.CommonComponentItem;

public class ListGroupItemHeading extends CommonComponentItem {

	public ListGroupItemHeading() {
		this.addHtmlClass("list-group-item-heading");
		this.setHtmlTag("span");
	}

	public ListGroupItemHeading(String overridePrimeClass) {
		this.addHtmlClass(overridePrimeClass);
	}

}
