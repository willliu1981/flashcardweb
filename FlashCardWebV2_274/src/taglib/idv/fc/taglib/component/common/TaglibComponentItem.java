package idv.fc.taglib.component.common;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tool.taglib.Taglibs;

/*
 * 由 ListGroupItem、Badge 等實作
 */
public interface TaglibComponentItem {

	void setText(String text);

	String getText();

	void setHtmlTag(String htmlTag);

	String getHtmlTag();

	void onClick(String script);

	String getOnClickScript();

	TaglibComponentItem addHtmlClass(String htmlClass);

	TaglibComponentItem addStyleSheet(String sheet);

	TaglibComponentItem addAttribute(String name, String value);

	List<String> getHtmlClasses();

	List<String> getStyleSheets();

	Map<String, String> getAttributes();

	default public String getHtmlCode() {
		StringBuilder sb = new StringBuilder();

		String onClickScript = "onclick=\"" + getOnClickScript() + "\"";

		sb.append("<").append(this.getHtmlTag());//prifix begin
		sb.append(Taglibs.getHtmlClasses(getHtmlClasses()));// class
		sb.append(Taglibs.getStyleSheets(getStyleSheets()));// css
		sb.append(Taglibs.getAttributes(getAttributes()));//attribute
		sb.append(onClickScript);//onclick
		sb.append(">");//prifix end

		sb.append(this.getText());//data
		sb.append("</").append(this.getHtmlTag()).append("/>");//suffix

		return sb.toString();
	}
}
