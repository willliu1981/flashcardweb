package idv.fc.model.dto;

import idv.fc.model.Flashcard;
import idv.fc.model.FlashcardHolder;

public class FlashcardHolderDTO extends FlashcardHolder
		implements java.io.Serializable {

	private Flashcard flashcard;

	public Flashcard getFlashcard() {
		return flashcard;
	}

	public void setFlashcard(Flashcard fc) {
		this.flashcard = fc;
	}



}
