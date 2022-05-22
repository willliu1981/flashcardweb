package idv.fc.model.dto;

import java.sql.Timestamp;

import idv.fc.model.Flashcard;
import idv.fc.model.FlashcardHolder;

public class FlashcardHolderDTO {
	private FlashcardHolder fh = new FlashcardHolder();
	private Flashcard flashcard;

	public Integer getId() {
		return fh.getId();
	}

	public void setId(Integer id) {
		fh.setId(id);
	}

	public String getName() {
		return fh.getName();
	}

	public void setName(String name) {
		fh.setName(name);
	}

	public Integer getFcId() {
		return fh.getFcId();
	}

	public void setFcId(Integer fcId) {
		fh.setFcId(fcId);
	}

	public Timestamp getCreateDate() {
		return fh.getCreateDate();
	}

	public void setCreateDate(Timestamp createDate) {
		fh.setCreateDate(createDate);
	}

	public Integer getNumberOfQuizTimes() {
		return fh.getNumberOfQuizTimes();
	}

	public void setNumberOfQuizTimes(Integer numberOfQuizTimes) {
		fh.setNumberOfQuizTimes(numberOfQuizTimes);
	}

	public Integer getPassTheQuizTimes() {
		return fh.getPassTheQuizTimes();
	}

	public void setPassTheQuizTimes(Integer passTheQuizTimes) {
		fh.setPassTheQuizTimes(passTheQuizTimes);
	}

	public Flashcard getFlashcard() {
		return flashcard;
	}

	public void setFlashcard(Flashcard fc) {
		this.flashcard = fc;
	}

	@Override
	public String toString() {
		return "FlashcardHolderDTO [fh=" + fh + ", flashcard=" + flashcard
				+ "]";
	}

}
