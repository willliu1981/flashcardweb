package idv.fc.taglib.component.listgroup.renderer.impl;

import idv.fc.model.Flashcard;
import idv.fc.taglib.component.Badge;
import idv.fc.taglib.component.listgroup.ListGroupItemHeading;
import idv.fc.taglib.component.listgroup.ListGroupItemText;
import idv.fc.taglib.component.listgroup.renderer.ListGroupRenderer;

public class FlashcardListGroupRenderer
		implements ListGroupRenderer<Flashcard> {

	@Override
	public String getRenderedBefore(Flashcard model) {

		return SKIP;
	}

	@Override
	public String getRenderedResult(Flashcard model) {
		Badge deleteBadge = new Badge();
		deleteBadge.addStyleSheet("background:red");
		deleteBadge.addStyleSheet("font-size:18px");
		deleteBadge.setText("DELETE");

		Badge editBadge = new Badge();
		//editBadge.addStyleSheet("background:blue");//註解以使用預設藍色
		editBadge.addStyleSheet("font-size:17px");
		editBadge.setText("EDIT");

		ListGroupItemHeading heading = new ListGroupItemHeading();
		heading.addHtmlClass("h3");
		heading.setText(model.getTerm());

		ListGroupItemText text = new ListGroupItemText();
		//text.addHtmlClass("h4");//改變font size , 但也改變了顏色
		text.addStyleSheet("font-size:22px");
		text.setText(model.getDefinition());

		//組合
		StringBuilder sb = new StringBuilder();
		sb.append(deleteBadge.getHtmlCode()).append(editBadge.getHtmlCode());//badge
		sb.append(heading.getHtmlCode()).append(" ").append(text.getHtmlCode());//heading & text

		return sb.toString();
	}

	@Override
	public String getRenderedAfter(Flashcard model) {
		return SKIP;
	}

}
