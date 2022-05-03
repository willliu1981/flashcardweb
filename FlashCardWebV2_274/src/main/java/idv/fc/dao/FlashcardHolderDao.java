package idv.fc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import idv.fc.model.FlashcardHolder;

@Repository
public interface FlashcardHolderDao {

	List<FlashcardHolder> selectAll();

	FlashcardHolder selectById(String id);

	public void create(FlashcardHolder flashcard);

	public void update(FlashcardHolder flashcard);

	public void delete(String id);

}
