package idv.fc.model.dto;

import idv.fc.model.Flashcard;
import idv.fc.model.FlashcardHolder;

public class FHDTO extends FlashcardHolder {
	private Flashcard flashcard;

	public Flashcard getFlashcard() {
		return flashcard;
	}

	public void setFlashcard(Flashcard flashcard) {
		this.flashcard = flashcard;
	}

	@Override
	public String toString() {
		return "FHDTO [flashcard=" + flashcard + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getFcId()=" + getFcId()
				+ ", getCreateDate()=" + getCreateDate()
				+ ", getNumberOfQuizTimes()=" + getNumberOfQuizTimes()
				+ ", getPassTheQuizTimes()=" + getPassTheQuizTimes()
				+ ", getUpdateForQuizDate()=" + getUpdateForQuizDate() + "]";
	}

}
