package idv.fc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import idv.fc.pojo.Vocabulary;

@Repository
public interface VocabularyDao {

	List<Vocabulary> queryAll();

}
