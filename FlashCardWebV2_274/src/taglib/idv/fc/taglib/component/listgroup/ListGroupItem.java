package idv.fc.taglib.component.listgroup;

import java.util.ArrayList;
import java.util.List;

import idv.fc.taglib.component.TaglibComponent;

public class ListGroupItem implements TaglibComponent {

	protected String text;
	protected String htmlTag = "span";
	protected List<String> htmlClasses = new ArrayList<>();
	protected List<String> styleSheets = new ArrayList<>();

	public ListGroupItem() {
	}

	public ListGroupItem(String primeClass) {
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
	public ListGroupItem addHtmlClass(String htmlClass) {
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

}
