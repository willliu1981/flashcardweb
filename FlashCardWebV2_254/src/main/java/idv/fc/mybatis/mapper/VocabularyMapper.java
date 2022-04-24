package idv.fc.mybatis.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import idv.fc.pojo.Vocabulary;

@Repository
public interface VocabularyMapper {

	List<Vocabulary> queryAll();

}
