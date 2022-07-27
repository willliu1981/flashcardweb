package idv.kw.tag.itf;

import java.util.List;
import java.util.Map;

import idv.kw.tag.tool.Components;

public interface IComponent {
	String EMPTY="";
	
	IComponent addBody(String text);

	String getBody();

	void setHtmlTag(String htmlTag);

	String getHtmlTag();

	void setClick(String script);

	String getOnClickScript();

	IComponent addHtmlClass(String htmlClass);

	IComponent addStyleSheet(String sheet);

	IComponent addAttribute(String name, String value);

	List<String> getHtmlClasses();

	List<String> getStyleSheets();

	Map<String, String> getAttributes();

	default public String getString() {
		StringBuilder sb = new StringBuilder();

		String onClickScript = "onclick=\"" + getOnClickScript() + "\"";

		sb.append("<").append(this.getHtmlTag());//prifix begin
		sb.append(Components.getHtmlClasses(getHtmlClasses()));// class
		sb.append(Components.getStyleSheets(getStyleSheets()));// css
		sb.append(Components.getAttributes(getAttributes()));//attribute
		sb.append(onClickScript);//onclick
		sb.append(">");//prifix end

		sb.append(this.getBody());//data
		sb.append("</").append(this.getHtmlTag()).append(">");//suffix

		return sb.toString();
	}

}
