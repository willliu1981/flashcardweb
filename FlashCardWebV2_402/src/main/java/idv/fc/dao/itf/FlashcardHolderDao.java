package idv.fc.dao.itf;

import java.util.List;

import org.springframework.stereotype.Repository;

import idv.fc.model.FlashcardHolder;
import idv.fc.model.dto.FlashcardHolderDTO;
import idv.fc.model.dto.FlashcardHolderListDTO;

@Repository
public interface FlashcardHolderDao extends Dao<FlashcardHolder> {

	List<FlashcardHolderDTO> selectAllJoinFc();

	FlashcardHolderDTO selectByIdJoinFc(Object id);

}
