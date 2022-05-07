package idv.fc.taglib.component.listgroup.renderer.impl;

import idv.fc.model.Flashcard;
import idv.fc.taglib.component.listgroup.ListGroupHeading;
import idv.fc.taglib.component.listgroup.renderer.ListGroupRenderer;

public class FlashcardListGroupRenderer
		implements ListGroupRenderer<Flashcard> {

	@Override
	public String getRenderedResult(Flashcard model) {
		//Badge badge=new Badge();
		ListGroupHeading heading = new ListGroupHeading();
		heading.addHtmlClass("h4");
		heading.setHtmlTag("h4");
		heading.setText(model.getTerm());

		String htmlCode = heading.getHtmlCode();
		
		return htmlCode;
	}

}
