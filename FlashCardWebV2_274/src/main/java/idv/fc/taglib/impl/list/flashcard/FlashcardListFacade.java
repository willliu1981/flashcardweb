package idv.fc.taglib.impl.list.flashcard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import idv.debug.Debug;
import idv.fc.model.Flashcard;
import idv.taglib.component.listgroup.ListGroup;
import idv.taglib.component.listgroup.renderer.ListGroupRenderere;
import idv.taglib.component.modal.Modal;
import idv.taglib.controlmodel.ContextPath;
import idv.taglib.factory.lister.ListFacade;
import idv.taglib.factory.lister.ListFacadeAdapter;
import idv.taglib.listgroup.listmodel.DefaultListGroupModel;
import idv.taglib.listgroup.listmodel.ListGroupModel;

public class FlashcardListFacade extends ListFacadeAdapter<Flashcard> {
	private final String pathForCRUD = "flashcard";
	private final String pathForPager = "flashcards/fcManager";
	private static String title = "Flashcard";// 傳入 Renderer 的 Title
	private static String jumbotronTitle = "管理 Flashcard";//managedPage 顯示 巨屏 Title
	private static String active = "flashcardManager";//managedPage 導航欄 的 active

	public FlashcardListFacade(List<Flashcard> datas) {
		super(datas);
	}

	@Override
	protected void configureListGroupAndModal(ListGroup<Flashcard> listGroup,
			Modal<Flashcard> modal) {
		
		DefaultListGroupModel<Flashcard> model = new DefaultListGroupModel<>();
		this.getDatas().stream().forEach(item -> model.addItem(item));
		listGroup.setModel(model);

		FlashcardListGroupRenderer lgRenderer = new FlashcardListGroupRenderer(
				this, title);
		listGroup.setRenderer(lgRenderer);

		FlashcardDeleteModalRenderer dmRenderer = new FlashcardDeleteModalRenderer(
				this, title);
		modal.setRenderer(dmRenderer);

	}

	@Override
	public String getJumbotronTitle() {
		return this.jumbotronTitle;
	}

	@Override
	public String getActive() {
		return this.active;
	}

	@Override
	public String getPathForCRUD() {
		return this.pathForCRUD;
	}

	@Override
	public String getPathForPager() {
		return this.pathForPager;
	}

}
