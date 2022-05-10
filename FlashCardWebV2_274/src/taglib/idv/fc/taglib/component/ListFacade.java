package idv.fc.taglib.component;

public abstract class ListFacade {

	public abstract boolean hasNextListItem();

	public abstract String getListHeader();

	public abstract String getListItem();

	public abstract String getModalHeader();

	public abstract String getModalBody();

	public abstract String getModalFooter();

	public abstract void setContextPath(String contextPath);

	public abstract ContextPath getContextPath();

	public abstract String getJumbotronTitle();

	public abstract String getActive();

	public abstract String getPathForCRUD();

	public abstract String getPathForPager();

}
