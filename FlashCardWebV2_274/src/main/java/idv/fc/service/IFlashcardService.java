package idv.fc.service;

import java.util.List;

import idv.fc.model.Flashcard;

public interface IFlashcardService {

	public List<Flashcard> getAll();

	Flashcard getById(String id);

	public void addNew(Flashcard flashcard);

	public void edit(Flashcard flashcard);
}
