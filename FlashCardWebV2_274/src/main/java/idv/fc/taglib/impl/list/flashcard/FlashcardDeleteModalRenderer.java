package idv.fc.taglib.impl.list.flashcard;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import idv.fc.model.Flashcard;
import idv.taglib.component.common.impl.Form;
import idv.taglib.component.common.impl.ModalBodyItem;
import idv.taglib.component.itf.Renderable;
import idv.taglib.component.modal.ModalTitle;
import idv.taglib.component.modal.renderer.ModalRenderer;
import idv.taglib.factory.ListFacade;
import tool.taglib.Taglibs;

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
		StringBuilder sbAction = Taglibs.getStringBuilder()
				.append(this.facade.getContextPath().getPath()).append("/")
				.append(this.facade.getPathForCRUD()).append("/");

		Form form = new Form();
		form.setId("modal_form");
		form.setAction(sbAction.toString());
		form.setMethod("post");
		form.setBody(Renderable.BODY);

		return form.getHtmlCode();
	}

}
