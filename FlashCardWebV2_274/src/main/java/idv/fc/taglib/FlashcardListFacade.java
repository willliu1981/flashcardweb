package idv.fc.taglib;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import idv.fc.model.Flashcard;
import idv.taglib.component.ContextPath;
import idv.taglib.component.ListFacade;
import idv.taglib.component.listgroup.ListGroup;
import idv.taglib.component.listgroup.renderer.ListGroupRenderere;
import idv.taglib.component.modal.Modal;
import idv.taglib.listgroup.listmodel.DefaultListGroupModel;
import idv.taglib.listgroup.listmodel.ListGroupModel;
import tool.Debug;

public class FlashcardListFacade extends ListFacade {
	private final String pathForCRUD = "flashcard";
	private final String pathForPager = "flashcards/fcManager";
	public static String EMPTY = "";
	private static String title = "Flashcard";// 傳入 Renderer 的 Title
	private static String jumbotronTitle = "管理 Flashcard";//managedPage 顯示 巨屏 Title
	private static String active = "flashcardManager";//managedPage 導航欄 的 active
	private ListGroup<Flashcard> listGroup;//tag 組件
	private Modal<Flashcard> modal;//tag 組件
	private ContextPath contextPath = new ContextPath();//可由 Tag 傳入 contextPath

	public FlashcardListFacade() {

	}

	public FlashcardListFacade(List<Flashcard> datas) {
		listGroup = new ListGroup<>();
		DefaultListGroupModel<Flashcard> model = new DefaultListGroupModel<>();
		datas.stream().forEach(item -> model.addItem(item));
		listGroup.setModel(model);

		FlashcardListGroupRenderer fclgRenderer = new FlashcardListGroupRenderer(
				this, title);
		listGroup.setRenderer(fclgRenderer);

		modal = new Modal<>();
		FlashcardDeleteModalRenderer fcdmRenderer = new FlashcardDeleteModalRenderer(
				this, title);
		modal.setRenderer(fcdmRenderer);
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

		return FlashcardListFacade.EMPTY;
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
