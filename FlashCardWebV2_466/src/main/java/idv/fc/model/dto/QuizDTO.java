package idv.fc.model.dto;

import idv.fc.model.Flashcard;

public class QuizDTO {
	private Flashcard flashcard;

	public QuizDTO() {

	}

	public QuizDTO(Flashcard flashcard) {
		this.flashcard = flashcard;
	}

	public String getTerm() {
		return flashcard.getTerm();
	}

	public void setTerm(String term) {
		flashcard.setTerm(term);
	}

	public String getDefinition() {
		return flashcard.getDefinition();
	}

	public void setDefinition(String definition) {
		flashcard.setDefinition(definition);
	}

	@Override
	public String toString() {
		return "QuizDTO [getTerm()=" + getTerm() + ", getDefinition()="
				+ getDefinition() + "]";
	}

}
