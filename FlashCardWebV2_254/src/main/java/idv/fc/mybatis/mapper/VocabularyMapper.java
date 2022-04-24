package idv.fc.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import idv.fc.pojo.Vocabulary;

public interface VocabularyMapper {

	List<Vocabulary> queryAll();


}
