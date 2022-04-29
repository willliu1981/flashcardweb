package idv.fc.model;

import java.sql.Timestamp;

public class Flashcard {

	private String id;
	private String term;
	private String definition;
	private Timestamp createDate;
	private Integer numberOfQuizTimes;
	private Integer passTheQuizTimes;

	private Flashcard() {
		super();
	}

	private Flashcard(String id, String term, String definition) {
		super();
		this.id = id;
		this.term = term;
		this.definition = definition;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Integer getNumberOfQuizTimes() {
		return numberOfQuizTimes;
	}

	public void setNumberOfQuizTimes(Integer numberOfQuizTimes) {
		this.numberOfQuizTimes = numberOfQuizTimes;
	}

	public Integer getPassTheQuizTimes() {
		return passTheQuizTimes;
	}

	public void setPassTheQuizTimes(Integer passTheQuizTimes) {
		this.passTheQuizTimes = passTheQuizTimes;
	}

	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", term=" + term + ", definition="
				+ definition + ", createDate=" + createDate
				+ ", numberOfQuizTimes=" + numberOfQuizTimes
				+ ", passTheQuizTimes=" + passTheQuizTimes + "]";
	}

}
