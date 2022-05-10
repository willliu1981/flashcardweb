package idv.fc.taglib.component.facade.impl;

import java.util.List;

import idv.fc.model.FlashcardHolder;
import idv.fc.taglib.component.ContextPath;
import idv.fc.taglib.component.ListFacade;
import idv.fc.taglib.component.listgroup.ListGroup;
import idv.fc.taglib.component.listgroup.listmodel.DefaultListGroupModel;
import idv.fc.taglib.component.listgroup.renderer.impl.FlashcardHolderListGroupRenderer;
import idv.fc.taglib.component.modal.Modal;
import idv.fc.taglib.component.modal.renderer.impl.FlashcardHolderDeleteModalRenderer;

public class FlashcardHolderListFacade extends ListFacade {
	private final String pathForCRUD = "flashcardHolder";
	private final String pathForPager = "flashcards/fhManager";
	public static String EMPTY = "";
	private static String title = "Flashcard";// 傳入 Renderer 的 Title
	private static String jumbotronTitle = "管理 FlashcardHolder";//managedPage 顯示 巨屏 Title
	private static String active = "flashcardHolderManager";//managedPage 導航欄 的 active
	private ListGroup<FlashcardHolder> listGroup;//tag 組件
	private Modal<FlashcardHolder> modal;//tag 組件
	private ContextPath contextPath = new ContextPath();//可由 Tag 傳入 contextPath

	public FlashcardHolderListFacade() {

	}

	public FlashcardHolderListFacade(List<FlashcardHolder> datas) {
		listGroup = new ListGroup<>();
		DefaultListGroupModel<FlashcardHolder> model = new DefaultListGroupModel<>();
		datas.stream().forEach(item -> model.addItem(item));
		listGroup.setModel(model);

		FlashcardHolderListGroupRenderer fclgRenderer = new FlashcardHolderListGroupRenderer(
				this, title);
		listGroup.setRenderer(fclgRenderer);

		modal = new Modal<>();
		FlashcardHolderDeleteModalRenderer fcdmRenderer = new FlashcardHolderDeleteModalRenderer(
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

		return FlashcardHolderListFacade.EMPTY;
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
