package idv.fc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.fc.dao.FlashcardHolderDao;
import idv.fc.model.FlashcardHolder;

@Service("flashcardHolderService")
public class FlashcardHolderServiceImpl implements IFlashcardHolderService {

	@Autowired
	//@Resource
	private FlashcardHolderDao flashcardHolderDao;

	@Override
	public List<FlashcardHolder> getAll() {
		return flashcardHolderDao.selectAll();
	}

	@Override
	public FlashcardHolder getById(String id) {
		return flashcardHolderDao.selectById(id);
	}

	@Override
	public void addNew(FlashcardHolder flashcard) {
		flashcardHolderDao.create(flashcard);
	}

	@Override
	public void edit(FlashcardHolder flashcard) {
		flashcardHolderDao.update(flashcard);
	}

	@Override
	public void remove(String id) {
		flashcardHolderDao.delete(id);
	}

}
