package idv.fc.taglib.component;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import idv.fc.model.Flashcard;
import idv.fc.taglib.component.listgroup.ListGroup;
import idv.fc.taglib.component.listgroup.listmodel.DefaultListGroupModel;
import idv.fc.taglib.component.listgroup.listmodel.ListGroupModel;
import idv.fc.taglib.component.listgroup.renderer.ListGroupRenderere;
import idv.fc.taglib.component.listgroup.renderer.impl.FlashcardListGroupRenderer;
import idv.fc.taglib.component.modal.Modal;
import idv.fc.taglib.component.modal.renderer.impl.FlashcardDeleteModalRenderer;

public class FlashcardListFacade extends ListFacade {
	public static String EMPTY = "";
	private ListGroup<Flashcard> listGroup;
	private Modal<Flashcard> modal;

	public FlashcardListFacade(HttpServletRequest request,
			List<Flashcard> datas) {
		DefaultListGroupModel<Flashcard> model = new DefaultListGroupModel<>();
		datas.stream().forEach(item -> model.addItem(item));
		listGroup.setModel(model);

		FlashcardListGroupRenderer fclgRenderer = new FlashcardListGroupRenderer(
				request);
		listGroup.setRenderer(fclgRenderer);

		FlashcardDeleteModalRenderer fcdmRenderer = new FlashcardDeleteModalRenderer(
				request);
		modal.setRenderer(fcdmRenderer);
	}

	@Override
	public String getListTitle() {
		return this.listGroup.getTitleResult();
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
	public String getModalBody() {
		return this.modal.getBodyResult();
	}

}
