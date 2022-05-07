package idv.fc.taglib.component;

import java.util.List;
import java.util.stream.Collectors;

import idv.fc.taglib.component.listgroup.ListGroupHeading;

public interface TaglibComponent {

	void setText(String text);

	String getText();

	void setHtmlTag(String htmlTag);

	String getHtmlTag();

	ListGroupHeading addHtmlClass(String htmlClass);

	List<String> getHtmlClasses();

	default public String getHtmlCode() {
		StringBuilder sb = new StringBuilder();

		String htmlClasses = getHtmlClasses().stream()
				.collect(Collectors.joining(" ", " class=", ""));
		sb.append("<").append(this.getHtmlTag()).append(htmlClasses)
				.append(">");//prifix
		sb.append(this.getText());//data
		sb.append("</").append(this.getHtmlTag()).append("/>");//suffix

		return sb.toString();
	}
}
