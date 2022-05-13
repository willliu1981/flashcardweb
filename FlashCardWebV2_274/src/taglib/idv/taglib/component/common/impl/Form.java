package idv.taglib.component.common.impl;

import idv.taglib.component.common.CommonComponent;

public class Form extends CommonComponent {

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
