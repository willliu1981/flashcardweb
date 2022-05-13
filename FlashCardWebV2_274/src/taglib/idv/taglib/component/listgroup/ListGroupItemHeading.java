package idv.taglib.component.listgroup;

import idv.taglib.component.common.CommonComponent;

public class ListGroupItemHeading extends CommonComponent {

	public ListGroupItemHeading() {
		this.addHtmlClass("list-group-item-heading");
		this.setHtmlTag("span");
	}

	public ListGroupItemHeading(String overridePrimeClass) {
		this.addHtmlClass(overridePrimeClass);
	}

}
