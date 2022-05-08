package idv.fc.taglib.component;

import idv.fc.taglib.component.listgroup.ListGroup;
import idv.fc.taglib.component.modal.Modal;

public class Facade<T> {
	public static String EMPTY = "";
	private ListGroup<T> listGroup;
	private Modal<T> modal;

	public Facade(ListGroup<T> listGroup, Modal<T> modal) {
		super();
		this.listGroup = listGroup;
		this.modal = modal;
	}

	public String getListTitle() {
		return this.listGroup.getTitleResult();
	}

	public String getListItem() {
		if (this.listGroup.hasNext()) {
			return this.listGroup.getNextBodyResult();
		}

		return Facade.EMPTY;
	}

	public String getModalBody() {
		return this.modal.getBodyResult();
	}

}
