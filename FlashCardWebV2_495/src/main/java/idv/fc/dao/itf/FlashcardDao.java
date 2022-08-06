package idv.fc.dao.itf;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import idv.fc.model.Flashcard;

@Repository
public interface FlashcardDao extends Dao<Flashcard> {

	public Flashcard selectByTerm(String term) throws SQLException;

	public List<Flashcard> selectByTermUsingLike(String pattern)
			throws SQLException;

	public Integer countByTermUsingLikeLeadByPattern(String pattern)
			throws SQLException;
	
	public Integer countByTermUsingLike(String pattern)
			throws SQLException;

}
