package idv.fc.taglib.component.listgroup.renderer.impl;

import idv.fc.model.Flashcard;
import idv.fc.taglib.component.listgroup.ListGroupItemHeading;
import idv.fc.taglib.component.listgroup.ListGroupItemText;
import idv.fc.taglib.component.listgroup.renderer.ListGroupRenderer;

public class FlashcardListGroupRenderer
		implements ListGroupRenderer<Flashcard> {

	@Override
	public String getRenderedResult(Flashcard model) {
		//Badge badge=new Badge();
		ListGroupItemHeading heading = new ListGroupItemHeading();
		heading.addHtmlClass("h3");
		heading.setText(model.getTerm());

		ListGroupItemText text = new ListGroupItemText();
		//text.addHtmlClass("h4");
		text.addStyleSheet("font-size:22px");
		text.setText(model.getDefinition());

		String headingHtmlCode = heading.getHtmlCode();
		String textHtmlCode = text.getHtmlCode();

		StringBuilder sb = new StringBuilder();
		sb.append(headingHtmlCode).append(" ").append(textHtmlCode);

		return sb.toString();
	}

}
