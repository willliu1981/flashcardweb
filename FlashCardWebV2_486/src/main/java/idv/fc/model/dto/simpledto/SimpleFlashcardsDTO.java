package idv.fc.model.dto.simpledto;

import idv.fc.model.Flashcard;

public class SimpleFlashcardsDTO {

	private String baseRegex;
	private String[] fragmentRegexes;
	private Flashcard[] flashcards;
	private String ids;
	private String filter;

	public String getBaseRegex() {
		return baseRegex;
	}

	public void setBaseRegex(String baseRegex) {
		this.baseRegex = baseRegex;
	}

	public String[] getFragmentRegexes() {
		return fragmentRegexes;
	}

	public void setFragmentRegexes(String[] fragmentRegexes) {
		this.fragmentRegexes = fragmentRegexes;
	}

	public Flashcard[] getFlashcards() {
		return flashcards;
	}

	public void setFlashcards(Flashcard[] flashcards) {
		this.flashcards = flashcards;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

}
