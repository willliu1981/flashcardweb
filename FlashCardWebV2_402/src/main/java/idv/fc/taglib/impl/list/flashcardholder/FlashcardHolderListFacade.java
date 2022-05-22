package idv.fc.taglib.impl.list.flashcardholder;

import java.util.List;

import idv.fc.model.FlashcardHolder;
import idv.taglib.component.listgroup.ListGroup;
import idv.taglib.component.modal.Modal;
import idv.taglib.factory.lister.ListFacadeAdapter;
import idv.taglib.listgroup.listmodel.DefaultListGroupModel;

public class FlashcardHolderListFacade
		extends ListFacadeAdapter<FlashcardHolder> {

	private final String pathForCRUD = "flashcardHolder";
	private final String pathForPager = "flashcards/fhManager";
	private static String title = "Flashcard Holder";// 傳入 Renderer 的 Title
	private static String jumbotronTitle = "管理 Flashcard Holder";//managedPage 顯示 巨屏 Title
	private static String active = "flashcardHolderManager";//managedPage 導航欄 的 active

	public FlashcardHolderListFacade(List<FlashcardHolder> datas) {
		super(datas);
	}

	@Override
	protected void configureListGroupAndModal(
			ListGroup<FlashcardHolder> listGroup,
			Modal<FlashcardHolder> modal) {

		DefaultListGroupModel<FlashcardHolder> model = new DefaultListGroupModel<>();
		this.getDatas().stream().forEach(item -> model.addItem(item));
		listGroup.setModel(model);

		FlashcardHolderListGroupRenderer lgRenderer = new FlashcardHolderListGroupRenderer(
				this, title);
		listGroup.setRenderer(lgRenderer);

		FlashcardHolderDeleteModalRenderer dmRenderer = new FlashcardHolderDeleteModalRenderer(
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
