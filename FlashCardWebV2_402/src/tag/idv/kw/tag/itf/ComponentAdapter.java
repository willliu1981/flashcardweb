package idv.kw.tag.itf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ComponentAdapter implements IComponent {
	private String script;//onclick script
	private String text;// 文本框
	private String htmlTag;
	private List<String> htmlClasses = new ArrayList<>();
	private List<String> styleSheets = new ArrayList<>();
	private Map<String, String> attributes = new HashMap<>();

	public ComponentAdapter() {
	}

	public ComponentAdapter(String primeClass) {
		this.htmlClasses.add(primeClass);
	}

	@Override
	public IComponent addBody(String text) {
		if (this.text == null) {
			this.text = "";
		}
		this.text += text;

		return this;
	}

	@Override
	public void setHtmlTag(String htmlTag) {
		this.htmlTag = htmlTag;
	}

	@Override
	public IComponent addHtmlClass(String htmlClass) {
		this.htmlClasses.add(htmlClass);

		return this;
	}

	@Override
	public String getBody() {
		if (this.text == null) {
			return EMPTY;
		}
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
	public IComponent addStyleSheet(String sheet) {
		this.styleSheets.add(sheet);
		return this;
	}

	@Override
	public List<String> getStyleSheets() {
		return this.styleSheets;
	}

	@Override
	public void setClick(String script) {
		this.script = script;
	}

	@Override
	public String getOnClickScript() {
		return this.script;
	}

	@Override
	public IComponent addAttribute(String name, String value) {
		this.attributes.put(name, value);
		return this;
	}

	@Override
	public Map<String, String> getAttributes() {
		return this.attributes;
	}

	@Override
	public String toString() {
		return this.getString();
	}

}
