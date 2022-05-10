package idv.fc.taglib.component.modal.renderer.impl;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import idv.fc.model.Flashcard;
import idv.fc.taglib.component.ContextPath;
import idv.fc.taglib.component.ListFacade;
import idv.fc.taglib.component.common.impl.ModalBodyItem;
import idv.fc.taglib.component.modal.ModalTitle;
import idv.fc.taglib.component.modal.renderer.ModalRenderer;

public class FlashcardDeleteModalRenderer extends ModalRenderer<Flashcard> {
	private ListFacade facade;
	private String title;

	public FlashcardDeleteModalRenderer(ListFacade facade, String title) {
		this.facade = facade;
		this.title = title;
	}

	/*
	 * only Title info
	 */
	@Override
	public String getRenderedHeader() {
		ModalTitle title = new ModalTitle();
		title.setBody(this.title);

		return title.getHtmlCode();
	}

	@Override
	public String getRenderedBody() {
		ModalBodyItem label1 = new ModalBodyItem();
		label1.addStyleSheet("font-size:24px;");

		ModalBodyItem label2 = new ModalBodyItem();
		label2.addStyleSheet("font-size:20px;");

		return Stream.of(label1.getHtmlCode(), label2.getHtmlCode())
				.map(x -> "<p>" + x + "</p>").collect(Collectors.joining());
	}

	@Override
	public String getRenderedFooter() {

		return EMPTY;
	}

}
