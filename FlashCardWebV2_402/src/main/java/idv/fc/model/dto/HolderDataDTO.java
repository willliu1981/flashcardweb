package idv.fc.model.dto;

import java.sql.Timestamp;

import idv.fc.model.HolderData;
import idv.fc.model.Status;

public class HolderDataDTO {
	private HolderData hd = new HolderData();
	private FlashcardHolderDTO flashcardHolderDTO;
	private Status status;

	public String getName() {
		return this.flashcardHolderDTO.getName();
	}

	public Integer getId() {
		return hd.getId();
	}

	public void setId(Integer id) {
		hd.setId(id);
	}

	public Integer getFhId() {
		return hd.getFhId();
	}

	public void setFhId(Integer fh_id) {
		hd.setFhId(fh_id);
	}

	public Timestamp getCreateDate() {
		return hd.getCreateDate();
	}

	public void setCreateDate(Timestamp createDate) {
		hd.setCreateDate(createDate);
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public FlashcardHolderDTO getFlashcardHolderDTO() {
		return flashcardHolderDTO;
	}

	public void setFlashcardHolderDTO(FlashcardHolderDTO flashcardHolderDTO) {
		this.flashcardHolderDTO = flashcardHolderDTO;
	}

	@Override
	public String toString() {
		return "HolderDataDTO [hd=" + hd.getId() + ", flashcardHolderDTO="
				+ flashcardHolderDTO.getId() + ", status=" + status.getId()
				+ "]";
	}

	@Override
	public int hashCode() {
		return this.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (!obj.getClass().equals(this.getClass())) {
			return false;
		}
		HolderDataDTO other = (HolderDataDTO) obj;

		return this.getId().equals(other.getId());
	}

}
