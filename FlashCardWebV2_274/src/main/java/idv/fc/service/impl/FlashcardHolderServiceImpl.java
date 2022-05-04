package idv.fc.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.fc.dao.impl.FlashcardHolderDao;
import idv.fc.model.FlashcardHolder;
import idv.fc.service.abstraction.IFlashcardHolderService;

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
		try {
			return flashcardHolderDao.selectById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addNew(FlashcardHolder flashcard) {
		try {
			flashcardHolderDao.create(flashcard);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(FlashcardHolder flashcard) {
		try {
			flashcardHolderDao.update(flashcard);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String id) {
		try {
			flashcardHolderDao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
