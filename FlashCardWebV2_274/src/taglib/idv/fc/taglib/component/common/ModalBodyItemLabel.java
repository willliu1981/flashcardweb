package idv.fc.taglib.component.common;

public class ModalBodyItemLabel extends CommonComponentItem {

	public ModalBodyItemLabel() {
		this.addHtmlClass("modal-body-item");
		this.setHtmlTag("label");
	}

	public ModalBodyItemLabel(String overridePrimeClass) {
		this.addHtmlClass(overridePrimeClass);
	}

}
