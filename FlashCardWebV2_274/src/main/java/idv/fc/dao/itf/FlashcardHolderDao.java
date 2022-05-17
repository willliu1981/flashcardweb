package idv.fc.dao.itf;

import java.util.List;

import org.springframework.stereotype.Repository;

import idv.fc.dto.FlashcardHolderDTO;
import idv.fc.model.FlashcardHolder;

@Repository
public interface FlashcardHolderDao extends Dao<FlashcardHolder> {

	List<FlashcardHolderDTO> selectAllJoinFc();
}
