package idv.taglib.component.common.impl;

import idv.taglib.component.common.CommonComponent;

public class ModalBodyItem extends CommonComponent {

	public ModalBodyItem() {
		this.addHtmlClass("modal-body-item");
		this.setHtmlTag("label");
	}

	public ModalBodyItem(String overridePrimeClass) {
		this.addHtmlClass(overridePrimeClass);
	}

}
