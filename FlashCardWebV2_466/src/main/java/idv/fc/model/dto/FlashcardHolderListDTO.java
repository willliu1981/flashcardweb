package idv.fc.model.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;

import idv.fc.model.Flashcard;
import idv.fc.model.FlashcardHolder;

//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FlashcardHolderListDTO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FlashcardHolder flashcardHolder;
	private Flashcard flashcard;

	public FlashcardHolderListDTO(FlashcardHolder flashcardHolder,
			Flashcard flashcard) {
		super();
		this.flashcardHolder = flashcardHolder;
		this.flashcard = flashcard;
	}

	public Flashcard getFlashcard() {
		return flashcard;
	}

	public String getTerm() {
		return flashcard.getTerm();
	}

	public String getDefinition() {
		return flashcard.getDefinition();
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

	public Timestamp getUpdateForQuizDate() {
		return flashcardHolder.getUpdateForQuizDate();
	}

	public void setUpdateForQuizDate(Timestamp updateForQuizDate) {
		flashcardHolder.setUpdateForQuizDate(updateForQuizDate);
	}

	/*@Override
	public String toString() {
		return "FlashcardHolderListDTO [fh=" + flashcardHolder + ", flashcard="
				+ flashcard + "]";
	}*/

}
