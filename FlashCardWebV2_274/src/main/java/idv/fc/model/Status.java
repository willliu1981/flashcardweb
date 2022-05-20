package idv.fc.model;

import java.sql.Timestamp;

public class Status {
	private Integer id;
	private Timestamp beginTimeOfPhase;//進度時間戳記
	private Timestamp endTimeOfPhase;//進度時間戳記
	private Timestamp createDate;
	private Integer phase;//進度

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getBeginTimeOfPhase() {
		return beginTimeOfPhase;
	}

	public void setBeginTimeOfPhase(Timestamp timeOfPhase) {
		this.beginTimeOfPhase = timeOfPhase;
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
		return "Status [id=" + id + ", beginTimeOfPhase=" + beginTimeOfPhase
				+ ", endTimeOfPhase=" + endTimeOfPhase + ", createDate="
				+ createDate + ", phase=" + phase + "]";
	}

	public Timestamp getEndTimeOfPhase() {
		return endTimeOfPhase;
	}

	public void setEndTimeOfPhase(Timestamp endTimeOfPhase) {
		this.endTimeOfPhase = endTimeOfPhase;
	}

}
