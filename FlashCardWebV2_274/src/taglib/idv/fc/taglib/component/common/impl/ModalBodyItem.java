package idv.fc.taglib.component.common.impl;

import idv.fc.taglib.component.common.CommonComponentItem;

public class ModalBodyItem extends CommonComponentItem {

	public ModalBodyItem() {
		this.addHtmlClass("modal-body-item");
		this.setHtmlTag("label");
	}

	public ModalBodyItem(String overridePrimeClass) {
		this.addHtmlClass(overridePrimeClass);
	}

}
