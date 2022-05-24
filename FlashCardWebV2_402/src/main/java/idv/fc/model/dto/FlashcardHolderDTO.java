package idv.fc.model.dto;

import java.sql.Timestamp;

import idv.fc.model.Flashcard;
import idv.fc.model.FlashcardHolder;

public class FlashcardHolderDTO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private FlashcardHolder flashcardHolder = new FlashcardHolder();
	private Flashcard flashcard;

	public FlashcardHolder getFlashcardHolder() {
		return flashcardHolder;
	}

	public Integer getId() {
		return flashcardHolder.getId();
	}

	public void setId(Integer id) {
		flashcardHolder.setId(id);
	}

	public String getName() {
		return flashcardHolder.getName();
	}

	public void setName(String name) {
		flashcardHolder.setName(name);
	}

	public Integer getFcId() {
		return flashcardHolder.getFcId();
	}

	public void setFcId(Integer fcId) {
		flashcardHolder.setFcId(fcId);
	}

	public Timestamp getCreateDate() {
		return flashcardHolder.getCreateDate();
	}

	public void setCreateDate(Timestamp createDate) {
		flashcardHolder.setCreateDate(createDate);
	}

	public Integer getNumberOfQuizTimes() {
		return flashcardHolder.getNumberOfQuizTimes();
	}

	public void setNumberOfQuizTimes(Integer numberOfQuizTimes) {
		flashcardHolder.setNumberOfQuizTimes(numberOfQuizTimes);
	}

	public Integer getPassTheQuizTimes() {
		return flashcardHolder.getPassTheQuizTimes();
	}

	public void setPassTheQuizTimes(Integer passTheQuizTimes) {
		flashcardHolder.setPassTheQuizTimes(passTheQuizTimes);
	}

	public Flashcard getFlashcard() {
		return flashcard;
	}

	public void setFlashcard(Flashcard fc) {
		this.flashcard = fc;
	}

	/*	@Override
		public String toString() {
			return "FlashcardHolderDTO [fh=" + flashcardHolder + ", flashcard="
					+ flashcard + "]";
		}*/

}
