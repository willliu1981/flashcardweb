package idv.fc.taglib.component.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CommonComponentItem implements TaglibComponentItem {
	private String script;//onclick script
	private String text;// 文本框
	private String htmlTag;
	private List<String> htmlClasses = new ArrayList<>();
	private List<String> styleSheets = new ArrayList<>();
	private Map<String, String> attributes = new HashMap<>();

	public CommonComponentItem() {
	}

	public CommonComponentItem(String primeClass) {
		this.htmlClasses.add(primeClass);
	}

	@Override
	public void setBody(String text) {
		this.text = text;
	}

	@Override
	public void setHtmlTag(String htmlTag) {
		this.htmlTag = htmlTag;
	}

	@Override
	public CommonComponentItem addHtmlClass(String htmlClass) {
		this.htmlClasses.add(htmlClass);

		return this;
	}

	@Override
	public String getBody() {
		return this.text;
	}

	@Override
	public String getHtmlTag() {
		return this.htmlTag;
	}

	@Override
	public List<String> getHtmlClasses() {
		return this.htmlClasses;
	}

	@Override
	public TaglibComponentItem addStyleSheet(String sheet) {
		this.styleSheets.add(sheet);
		return this;
	}

	@Override
	public List<String> getStyleSheets() {
		return this.styleSheets;
	}

	@Override
	public void onClick(String script) {
		this.script = script;
	}

	@Override
	public String getOnClickScript() {
		return this.script;
	}

	@Override
	public TaglibComponentItem addAttribute(String name, String value) {
		this.attributes.put(name, value);
		return this;
	}

	@Override
	public Map<String, String> getAttributes() {
		return this.attributes;
	}

}
