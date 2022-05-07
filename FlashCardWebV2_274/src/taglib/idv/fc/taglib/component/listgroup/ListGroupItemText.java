package idv.fc.taglib.component.listgroup;

public class ListGroupItemText extends ListGroupItem {

	public ListGroupItemText() {
		this.htmlClasses.add("list-group-item-text");
	}

	public ListGroupItemText(String overridePrimeClass) {
		this.htmlClasses.add(overridePrimeClass);
	}
}
