package idv.fc.model;

import java.sql.Timestamp;

public class HolderData {
	private Integer id;
	private Integer fc_id;//fk , Flashcard
	private Integer fh_id;//fk , FlashcardHolder
	private Timestamp createDate;

	public HolderData() {
		super();
	}

	public HolderData(Integer fc_id, Integer fh_id) {
		super();
		this.fc_id = fc_id;
		this.fh_id = fh_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFc_id() {
		return fc_id;
	}

	public void setFc_id(Integer fc_id) {
		this.fc_id = fc_id;
	}

	public Integer getFh_id() {
		return fh_id;
	}

	public void setFh_id(Integer fh_id) {
		this.fh_id = fh_id;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}
