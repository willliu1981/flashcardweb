package idv.fc.service.abstraction;

import java.util.List;

import idv.fc.model.FlashcardHolder;
import idv.fc.model.dto.FlashcardHolderDTO;

public interface IFlashcardHolderService extends IService<FlashcardHolder> {

	List<FlashcardHolderDTO> getAllJoinFc();

}