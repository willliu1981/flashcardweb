package idv.fc.model.dto;

import idv.fc.model.Flashcard;
import idv.fc.model.FlashcardHolder;

public class FHDTO2 implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FlashcardHolder flashcardHolder;
	private Flashcard flashcard;
	
	

	public FHDTO2(FlashcardHolder flashcardHolder, Flashcard flashcard) {
		super();
		this.flashcardHolder = flashcardHolder;
		this.flashcard = flashcard;
	}

	public FlashcardHolder getFlashcardHolder() {
		return flashcardHolder;
	}

	public void setFlashcardHolder(FlashcardHolder flashcardHolder) {
		this.flashcardHolder = flashcardHolder;
	}

	public Flashcard getFlashcard() {
		return flashcard;
	}

	public void setFlashcard(Flashcard flashcard) {
		this.flashcard = flashcard;
	}

	@Override
	public String toString() {
		return "FHDTO2 [flashcardHolder=" + flashcardHolder + ", flashcard="
				+ flashcard + "]";
	}

}
