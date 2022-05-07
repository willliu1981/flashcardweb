package idv.fc.taglib.component.listgroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idv.fc.taglib.component.TaglibComponent;

public class CommonComponent implements TaglibComponent {
	private String script;//onclick script
	private String text;// 文本框
	private String htmlTag = "span";
	private List<String> htmlClasses = new ArrayList<>();
	private List<String> styleSheets = new ArrayList<>();
	private Map<String, String> attributes = new HashMap<>();

	public CommonComponent() {
	}

	public CommonComponent(String primeClass) {
		this.htmlClasses.add(primeClass);
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setHtmlTag(String htmlTag) {
		this.htmlTag = htmlTag;
	}

	@Override
	public CommonComponent addHtmlClass(String htmlClass) {
		this.htmlClasses.add(htmlClass);

		return this;
	}

	@Override
	public String getText() {
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
	public TaglibComponent addStyleSheet(String sheet) {
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
	public TaglibComponent addAttribute(String name, String value) {
		this.attributes.put(name, value);
		return this;
	}

	@Override
	public Map<String, String> getAttributes() {
		return this.attributes;
	}

}
