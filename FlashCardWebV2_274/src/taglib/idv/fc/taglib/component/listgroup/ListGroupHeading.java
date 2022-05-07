package idv.fc.taglib.component.listgroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import idv.fc.taglib.component.TaglibComponent;

public class ListGroupHeading implements TaglibComponent {

	private String text;
	private String htmlTag;
	private List<String> htmlClasses = new ArrayList<>();

	public ListGroupHeading() {
		this.htmlClasses.add("list-group-item-heading");
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
	public ListGroupHeading addHtmlClass(String htmlClass) {
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

}
