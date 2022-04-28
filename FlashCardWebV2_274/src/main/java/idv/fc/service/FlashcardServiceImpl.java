package idv.fc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.fc.dao.FlashcardDao;
import idv.fc.model.Flashcard;

@Service("flashcardService")
public class FlashcardServiceImpl implements IFlashcardService {

	@Autowired
	//@Resource
	private FlashcardDao flashcardDao;

	@Override
	public List<Flashcard> getAll() {
		return flashcardDao.queryAll();
	}

}
