package idv.fc.model;

import java.sql.Timestamp;

public class FlashcardHolder  implements java.io.Serializable {
	/**
	 * 
	 */
	private Integer id; //ai
	private String name;
	private Integer fcId;//fk: flashcard id
	private Timestamp createDate;
	private Integer numberOfQuizTimes;
	private Integer passTheQuizTimes;
	private Timestamp updateForQuizDate;

	public FlashcardHolder() {
		super();
	}

	public FlashcardHolder(Integer id, String name, Integer fcId) {
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

	public Integer getFcId() {
		return fcId;
	}

	public void setFcId(Integer fcId) {
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

	

	public Timestamp getUpdateForQuizDate() {
		return updateForQuizDate;
	}

	public void setUpdateForQuizDate(Timestamp updateForQuizDate) {
		this.updateForQuizDate = updateForQuizDate;
	}

	/*@Override
	public String toString() {
		return "FlashcardHolder [id=" + id + ", name=" + name + ", fcId=" + fcId
				+ ", createDate=" + createDate + ", numberOfQuizTimes="
				+ numberOfQuizTimes + ", passTheQuizTimes=" + passTheQuizTimes
				+ ", updateForQuizDate=" + updateForQuizDate + "]";
	}*/

}
