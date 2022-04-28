package idv.fc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import idv.fc.model.Flashcard;

@Repository
public interface FlashcardDao {

	List<Flashcard> queryAll();

}
