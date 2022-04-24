package idv.fc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.fc.dao.VocabularyDao;
import idv.fc.pojo.Vocabulary;

@Service("vocabularyService")
public class VocabularyServiceImpl implements IVocabularyService {

	@Autowired
	//@Resource
	private VocabularyDao vocabularyDao;

	@Override
	public List<Vocabulary> getAllVocabulary() {
		return vocabularyDao.queryAll();
	}

}
