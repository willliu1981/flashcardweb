package idv.fc.taglib.component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface TaglibComponent {

	void setText(String text);

	String getText();

	void setHtmlTag(String htmlTag);

	String getHtmlTag();

	void onClick(String script);

	String getOnClickScript();

	TaglibComponent addHtmlClass(String htmlClass);

	TaglibComponent addStyleSheet(String sheet);

	TaglibComponent addAttribute(String name, String value);

	List<String> getHtmlClasses();

	List<String> getStyleSheets();

	Map<String, String> getAttributes();

	default public String getHtmlCode() {
		StringBuilder sb = new StringBuilder();

		String htmlClasses = getHtmlClasses().stream()
				.collect(Collectors.joining(" ", " class=\"", "\""));

		String styleSheets = this.getStyleSheets().stream()
				.collect(Collectors.joining(";", "style=\"", "\""));

		String attributes = this.getAttributes().entrySet().stream()
				.map(es -> es.getKey() + "=\"" + es.getValue() + "\"")
				.collect(Collectors.joining(" "));

		String onClickScript = "onclick=\"" + getOnClickScript() + "\"";

		sb.append("<").append(this.getHtmlTag());//prifix begin
		sb.append(htmlClasses);// class
		sb.append(styleSheets);// css
		sb.append(attributes);//attribute
		sb.append(onClickScript);//onclick
		sb.append(">");//prifix end

		sb.append(this.getText());//data
		sb.append("</").append(this.getHtmlTag()).append("/>");//suffix

		return sb.toString();
	}
}
