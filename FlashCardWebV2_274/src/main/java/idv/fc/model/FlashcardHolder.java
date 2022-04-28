package idv.fc.model;

import java.sql.Timestamp;

public class FlashcardHolder {
	private Integer id; //ai
	private String name;
	private String fcId;//fk: flashcard id
	private Timestamp createDate;
	private Integer numberOfQuizTimes;
	private Integer passTheQuizTimes;

	private FlashcardHolder() {
		super();
	}

	private FlashcardHolder(Integer id, String name, String fcId) {
		super();
		this.id = id;
		this.name = name;
		this.fcId = fcId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFcId() {
		return fcId;
	}

	public void setFcId(String fcId) {
		this.fcId = fcId;
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
		return "HandledCard [id=" + id + ", name=" + name + ", fcId=" + fcId
				+ ", createDate=" + createDate + ", numberOfQuizTimes="
				+ numberOfQuizTimes + ", passTheQuizTimes=" + passTheQuizTimes
				+ "]";
	}

}
