package idv.fc.dto;

import java.sql.Timestamp;

import idv.fc.model.FlashcardHolder;
import idv.fc.model.HolderData;

public class HolderDataDTO {
	private HolderData hd = new HolderData();
	private FlashcardHolder flashcardHolder;

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

	public FlashcardHolder getFlashcardHolder() {
		return flashcardHolder;
	}

	public void setFlashcardHolder(FlashcardHolder flashcardHolder) {
		this.flashcardHolder = flashcardHolder;
	}

}
