package idv.fc.service.abstraction;

import java.util.List;

import idv.fc.dto.FlashcardHolderDTO;
import idv.fc.model.FlashcardHolder;

public interface IFlashcardHolderService extends IService<FlashcardHolder> {

	List<FlashcardHolderDTO> getAllJoinFc();

}
