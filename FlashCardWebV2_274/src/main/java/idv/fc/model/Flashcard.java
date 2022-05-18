package idv.fc.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Flashcard implements Serializable {

	private Integer id;
	private String term;
	private String definition;
	private Timestamp createDate;
	private Integer numberOfQuizTimes;
	private Integer passTheQuizTimes;

	public Flashcard() {
		super();
	}

	public Flashcard(Integer id, String term, String definition) {
		super();
		this.id = id;
		this.term = term;
		this.definition = definition;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
