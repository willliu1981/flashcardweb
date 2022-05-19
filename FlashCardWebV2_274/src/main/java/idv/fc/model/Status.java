package idv.fc.model;

import java.sql.Timestamp;

public class Status {
	private Integer id;
	private Timestamp timeOfPhase;//進度時間戳記
	private Timestamp createDate;
	private Integer phase;//進度

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getTimeOfPhase() {
		return timeOfPhase;
	}

	public void setTimeOfPhase(Timestamp timeOfPhase) {
		this.timeOfPhase = timeOfPhase;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Integer getPhase() {
		return phase;
	}

	public void setPhase(Integer phase) {
		this.phase = phase;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", timeOfPhase=" + timeOfPhase
				+ ", createDate=" + createDate + ", phase=" + phase + "]";
	}

}
