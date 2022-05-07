package idv.fc.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.fc.dao.impl.FlashcardDao;
import idv.fc.model.Flashcard;
import idv.fc.service.abstraction.IFlashcardService;

@Service("flashcardService")
public class FlashcardServiceImpl implements IFlashcardService {

	@Autowired
	private FlashcardDao flashcardDao;

	@Override
	public List<Flashcard> getAll() {
		return flashcardDao.selectAll();
	}

	@Override
	public Flashcard getById(String id) {
		try {
			return flashcardDao.selectById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addNew(Flashcard flashcard) {
		try {
			flashcardDao.create(flashcard);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Flashcard flashcard) {
		try {
			flashcardDao.update(flashcard);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String id) {
		try {
			flashcardDao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}