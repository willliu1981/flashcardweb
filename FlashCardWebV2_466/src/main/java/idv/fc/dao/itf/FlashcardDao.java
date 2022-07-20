package idv.fc.dao.itf;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import idv.fc.model.Flashcard;

@Repository
public interface FlashcardDao extends Dao<Flashcard> {

	public Flashcard selectByTerm(String term)throws SQLException;
	
}
