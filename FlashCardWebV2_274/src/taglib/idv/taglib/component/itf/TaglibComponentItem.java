package idv.taglib.component.itf;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tool.taglib.TaglibComponentItems;

/*
 * 由 ListGroupItem、Badge 等實作
 */
public interface TaglibComponentItem {

	TaglibComponentItem setBody(String text);

	String getBody();

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
		sb.append(TaglibComponentItems.getHtmlClasses(getHtmlClasses()));// class
		sb.append(TaglibComponentItems.getStyleSheets(getStyleSheets()));// css
		sb.append(TaglibComponentItems.getAttributes(getAttributes()));//attribute
		sb.append(onClickScript);//onclick
		sb.append(">");//prifix end

		sb.append(this.getBody());//data
		sb.append("</").append(this.getHtmlTag()).append(">");//suffix

		return sb.toString();
	}
}
