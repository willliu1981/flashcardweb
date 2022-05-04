package idv.fc.model;

import java.sql.Timestamp;

public class HolderData {
	private Integer id;
	private Integer fhId;//fk , FlashcardHolder
	private Timestamp createDate;

	public HolderData() {
		super();
	}

	public HolderData(Integer fhId) {
		super();
		this.fhId = fhId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFhId() {
		return fhId;
	}

	public void setFhId(Integer fh_id) {
		this.fhId = fh_id;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}
