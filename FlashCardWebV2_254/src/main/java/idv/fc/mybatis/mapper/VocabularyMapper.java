package idv.fc.mybatis.mapper;

import java.util.List;
import java.util.Map;

import idv.fc.pojo.Vocabulary;

public interface VocabularyMapper {

	Vocabulary queryByID(String id);

	int insertVocabulary();

	List<Vocabulary> getAllVocabulary();

	int updateVocabulary();

	Vocabulary checkLogin(String id, String vocabulry);

	Vocabulary checkLoginByMap(Map<String, String> map);
}
