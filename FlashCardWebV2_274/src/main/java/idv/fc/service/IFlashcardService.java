package idv.fc.service;

import java.util.List;

import idv.fc.model.Flashcard;

public interface IFlashcardService {

	public List<Flashcard> getAll();

	public void addNew(Flashcard flashcard);
}
