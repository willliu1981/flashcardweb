package idv.fc.taglib.component.common.impl;

import idv.fc.taglib.component.common.CommonComponentItem;

public class Form extends CommonComponentItem {

	public Form() {
		this.setHtmlTag("form");
	}

	public void setId(String code) {
		this.addAttribute("id", code);
	}

	public void setAction(String code) {
		this.addAttribute("action", code);
	}

	public void setMethod(String code) {
		this.addAttribute("method", code);
	}

}
