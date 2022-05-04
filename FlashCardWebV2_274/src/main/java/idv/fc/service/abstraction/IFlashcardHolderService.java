package idv.fc.service.abstraction;

import java.util.List;

import idv.fc.model.Flashcard;
import idv.fc.model.FlashcardHolder;

public interface IFlashcardHolderService {

	public List<FlashcardHolder> getAll();

	FlashcardHolder getById(String id);

	public void addNew(FlashcardHolder flashcardHolder);

	public void edit(FlashcardHolder flashcardHolder);

	public void remove(String id);
}
