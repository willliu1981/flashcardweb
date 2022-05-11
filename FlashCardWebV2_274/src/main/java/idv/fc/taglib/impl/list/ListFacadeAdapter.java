package idv.fc.taglib.impl.list;

import java.util.List;

import idv.taglib.component.ContextPath;
import idv.taglib.component.facade.ListFacade;
import idv.taglib.component.listgroup.ListGroup;
import idv.taglib.component.modal.Modal;

public abstract class ListFacadeAdapter<T> extends ListFacade {
	public static final String EMPTY = "";
	private ListGroup<T> listGroup;//tag 組件
	private Modal<T> modal;//tag 組件
	private ContextPath contextPath = new ContextPath();//可由 Tag 傳入 contextPath
	private List<T> datas;

	public ListFacadeAdapter(List<T> datas) {
		this.datas = datas;
		this.listGroup = new ListGroup<T>();
		this.modal = new Modal<T>();
		this.configureListGroupAndModal(this.listGroup, this.modal);
	}

	protected List<T> getDatas() {
		return datas;
	}

	protected ListGroup<T> getListGroup() {
		return listGroup;
	}

	protected Modal<T> getModal() {
		return modal;
	}

	protected void setListGroup(ListGroup<T> listGroup) {
		this.listGroup = listGroup;
	}

	protected void setModal(Modal<T> modal) {
		this.modal = modal;
	}

	protected abstract void configureListGroupAndModal(ListGroup<T> listGroup,
			Modal<T> modal);

	@Override
	public void setContextPath(String contextPath) {
		this.contextPath.setPath(contextPath);
	}

	@Override
	public String getListHeader() {
		return this.listGroup.getHeaderResult();
	}

	@Override
	public String getListItem() {
		if (this.listGroup.hasNext()) {
			return this.listGroup.getNextBodyResult();
		}

		return ListFacadeAdapter.EMPTY;
	}

	@Override
	public boolean hasNextListItem() {
		return this.listGroup.hasNext();
	}

	@Override
	public String getModalHeader() {
		return this.modal.getHeaderResult();
	}

	@Override
	public String getModalBody() {
		return this.modal.getBodyResult();
	}

	@Override
	public ContextPath getContextPath() {
		return this.contextPath;
	}

	@Override
	public String getModalFooter() {
		return this.modal.getFooterResult();
	}

}
