package idv.taglib.factory.lister;

import java.util.List;

import idv.taglib.component.listgroup.ListGroup;
import idv.taglib.component.modal.Modal;
import idv.taglib.controlmodel.ContextPath;
import idv.taglib.controlmodel.Result;

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
	public Result getListHeader() {
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
	public Result getModalHeader() {
		return this.modal.getHeaderResult();
	}

	@Override
	public Result getModalBody() {
		return this.modal.getBodyResult();
	}

	@Override
	public Result getModalFooter() {
		return this.modal.getFooterResult();
	}

	@Override
	public ContextPath getContextPath() {
		return this.contextPath;
	}

}