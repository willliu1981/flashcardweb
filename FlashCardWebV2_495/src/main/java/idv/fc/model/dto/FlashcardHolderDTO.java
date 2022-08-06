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

	@Override
	public String toString() {
		return "FlashcardHolderDTO [flashcard=" + flashcard.getId()
				+ ", FlashcardHolder=" + getId() + "]";
	}

	@Override
	public int hashCode() {
		return this.getId();
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (!obj.getClass().equals(this.getClass())) {
			return false;
		}
		FlashcardHolderDTO other = (FlashcardHolderDTO) obj;

		return this.getId().equals(other.getId());
	}

}
