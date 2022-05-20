package idv.fc.model.dto;

import java.sql.Timestamp;

import idv.fc.model.FlashcardHolder;
import idv.fc.model.HolderData;
import idv.fc.model.Status;

public class HolderDataDTO {
	private HolderData hd = new HolderData();
	private FlashcardHolderDTO flashcardHolderDTO;
	private Status status;
	
	private String aa;

	
	
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

	@Override
	public String toString() {
		return "HolderDataDTO [hd=" + hd + ", flashcardHolderDTO="
				+ flashcardHolderDTO + ", status=" + status + "]";
	}

	public FlashcardHolderDTO getFlashcardHolderDTO() {
		return flashcardHolderDTO;
	}

	public void setFlashcardHolderDTO(FlashcardHolderDTO flashcardHolderDTO) {
		this.flashcardHolderDTO = flashcardHolderDTO;
	}

	public String getAa() {
		return aa;
	}

	public void setAa(String aa) {
		this.aa = aa;
	}

}
