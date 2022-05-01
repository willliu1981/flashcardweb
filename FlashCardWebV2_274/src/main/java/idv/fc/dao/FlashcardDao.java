package idv.fc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import idv.fc.model.Flashcard;

@Repository
public interface FlashcardDao {

	List<Flashcard> selectAll();
	
	Flashcard selectById(String id);
	
	public void create(Flashcard flashcard);
	
	public void update(Flashcard flashcard);

}
