package idv.fc.taglib.impl.list;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import idv.fc.model.Flashcard;
import idv.taglib.component.ContextPath;
import idv.taglib.component.facade.ListFacade;
import idv.taglib.component.listgroup.ListGroup;
import idv.taglib.component.listgroup.renderer.ListGroupRenderere;
import idv.taglib.component.modal.Modal;
import idv.taglib.listgroup.listmodel.DefaultListGroupModel;
import idv.taglib.listgroup.listmodel.ListGroupModel;
import tool.Debug;

public class CommonListFacade extends ListFacade {
	public static final String EMPTY = "";
	private String pathForCRUD;
	private String pathForPager;
	private String jumbotronTitle;//managedPage 顯示 巨屏 Title
	private String active;//managedPage 導航欄 的 active
	private ListGroup<Flashcard> listGroup;//tag 組件
	private Modal<Flashcard> modal;//tag 組件
	private ContextPath contextPath = new ContextPath();//可由 Tag 傳入 contextPath

	public CommonListFacade() {

	}

	public CommonListFacade(ListGroup<Flashcard> listGroup,
			Modal<Flashcard> modal) {
		this.listGroup = listGroup;
		this.modal = modal;
	}

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

		return CommonListFacade.EMPTY;
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
	public String getJumbotronTitle() {
		return jumbotronTitle;
	}

	@Override
	public String getActive() {
		return active;
	}

	public static void setJumbotronTitle(String jumbotronTitle) {
		CommonListFacade.jumbotronTitle = jumbotronTitle;
	}

	public static void setActive(String active) {
		CommonListFacade.active = active;
	}

	@Override
	public String getPathForCRUD() {
		return pathForCRUD;
	}

	@Override
	public String getPathForPager() {
		return pathForPager;
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
