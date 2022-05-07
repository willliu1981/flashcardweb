package idv.fc.taglib.component;

import java.util.List;
import java.util.stream.Collectors;

import tool.Debug;

public interface TaglibComponent {

	void setText(String text);

	String getText();

	void setHtmlTag(String htmlTag);

	String getHtmlTag();

	TaglibComponent addHtmlClass(String htmlClass);

	TaglibComponent addStyleSheet(String sheet);

	List<String> getHtmlClasses();

	List<String> getStyleSheets();

	default public String getHtmlCode() {
		StringBuilder sb = new StringBuilder();

		String htmlClasses = getHtmlClasses().stream()
				.collect(Collectors.joining(" ", " class=\"", "\""));

		String styleSheets = this.getStyleSheets().stream()
				.collect(Collectors.joining(";", "style=\"", "\""));

		sb.append("<").append(this.getHtmlTag());//prifix begin
		sb.append(htmlClasses);// class
		sb.append(styleSheets);// css
		sb.append(">");//prifix end
		sb.append(this.getText());//data
		sb.append("</").append(this.getHtmlTag()).append("/>");//suffix

		return sb.toString();
	}
}
