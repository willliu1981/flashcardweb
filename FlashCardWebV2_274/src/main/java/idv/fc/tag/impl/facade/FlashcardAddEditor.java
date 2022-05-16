package idv.fc.tag.impl.facade;

import idv.fc.model.Flashcard;
import idv.kw.tag.facade.Editor;
import idv.kw.tag.model.Attribute;
import idv.kw.tag.model.Result;

public class FlashcardAddEditor extends Editor<Flashcard> {

	public FlashcardAddEditor(Flashcard data) {
		super(data);
	}

	@Override
	public void init() {
		this.addAttribute("formTitle", "新增 Flashcard");
	}

}
