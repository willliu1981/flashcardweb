package idv.fc.dao.itf;

import org.springframework.stereotype.Repository;

import idv.fc.dto.FlashcardHolderDTO;
import idv.fc.model.FlashcardHolder;

@Repository
public interface FlashcardHolderDao extends Dao<FlashcardHolder> {

	FlashcardHolderDTO selectByIdJoinFc(Object id);
}
