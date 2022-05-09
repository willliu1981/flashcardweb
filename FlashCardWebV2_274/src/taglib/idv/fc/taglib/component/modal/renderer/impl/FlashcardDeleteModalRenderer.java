package idv.fc.taglib.component.modal.renderer.impl;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import idv.fc.model.Flashcard;
import idv.fc.taglib.component.common.ModalBodyItemLabel;
import idv.fc.taglib.component.modal.renderer.ModalRenderer;

public class FlashcardDeleteModalRenderer extends ModalRenderer<Flashcard> {
	private String contextPath;

	public FlashcardDeleteModalRenderer(String contextPath) {
		this.contextPath = contextPath;
	}

	@Override
	public String getRenderedTitle() {
		return EMPTY;
	}

	@Override
	public String getRenderedBody() {
		ModalBodyItemLabel label1 = new ModalBodyItemLabel();
		label1.addStyleSheet("font-size:24px;");
		
		ModalBodyItemLabel label2 = new ModalBodyItemLabel();
		label2.addStyleSheet("font-size:20px;");

		return Stream.of(label1.getHtmlCode(), label2.getHtmlCode())
				.map(x -> "<p>" + x + "</p>").collect(Collectors.joining());
	}

	@Override
	public String getRenderedFooter() {
		return EMPTY;
	}

}
