package idv.fc.taglib.component.listgroup;

public class ListGroupItemHeading extends ListGroupItem {

	public ListGroupItemHeading() {
		this.htmlClasses.add("list-group-item-heading");
	}

	public ListGroupItemHeading(String overridePrimeClass) {
		this.htmlClasses.add(overridePrimeClass);
	}

}
