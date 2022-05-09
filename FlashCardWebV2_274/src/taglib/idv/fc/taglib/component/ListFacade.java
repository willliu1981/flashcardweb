package idv.fc.taglib.component;

public abstract class ListFacade {

	public abstract boolean hasNextListItem();

	public abstract String getListItem();

	public abstract String getModalBody();

	public abstract String getListTitle();

	public abstract String getModalTitle();

	public abstract void setContextPath(String contextPath);

}
