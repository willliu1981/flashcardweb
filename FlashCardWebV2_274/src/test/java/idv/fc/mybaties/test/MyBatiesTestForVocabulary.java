package idv.fc.mybaties.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import idv.fc.dao.FlashcardDao;
import idv.fc.model.Flashcard;
import idv.fc.mybatis.mapper.CardMapper;
import idv.fc.mybatis.mapper.VocabularyMapperOld;
import idv.fc.pojo.Card;
import idv.fc.pojo.Vocabulary;
import tool.Debug;
import tool.MapperMap;
import tool.MapperUtil;

public class MyBatiesTestForVocabulary {
	private final static Logger logger = LoggerFactory
			.getLogger(MyBatiesTestForVocabulary.class);
	static SqlSessionFactory sf;

	static {
		InputStream is = null;
		try {
			is = Resources
					.getResourceAsStream("idv/fc/mybatis/mybatis-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		sf = sfb.build(is);
	}

	@Test
	public void testInsert() throws IOException {

		SqlSession session = sf.openSession(true);
		VocabularyMapperOld mapper = session
				.getMapper(VocabularyMapperOld.class);

		Vocabulary vocabulary = new Vocabulary();
		vocabulary.setId("v_blue3");
		vocabulary.setVocabulary("blue3");
		vocabulary.setTranslation("blue3 xxx");

		int res = mapper.insertVocabulary(vocabulary);

		logger.info("vocabulary={}", vocabulary);
	}

	@Test
	public void testUpdate() throws IOException {

		SqlSession session = sf.openSession(true);
		VocabularyMapperOld mapper = session
				.getMapper(VocabularyMapperOld.class);

		int res = mapper.updateVocabulary();

		Debug.test(this, res);
	}

	@Test
	public void testQueryByID() throws IOException {

		SqlSession session = sf.openSession(true);
		VocabularyMapperOld mapper = session
				.getMapper(VocabularyMapperOld.class);

		Vocabulary queryByID = mapper.queryByID("v_at");

		Debug.test(this, queryByID);
	}

	//*	

	@Test
	public void testQueryAll() throws IOException {
		SqlSession session = sf.openSession();
		VocabularyMapperOld mapper = session
				.getMapper(VocabularyMapperOld.class);

		List<Vocabulary> allVocabulary = mapper.getAllVocabulary();

		Debug.test(this, allVocabulary);
	}//*/

	@Test
	public void testCheck() {
		SqlSession session = sf.openSession();
		VocabularyMapperOld mapper = session
				.getMapper(VocabularyMapperOld.class);

		Vocabulary checkLogin = mapper.checkLogin("v_yellow", "yellow");

		Debug.test(this, checkLogin);
	}

	@Test
	public void testCheckByMap() {
		SqlSession session = sf.openSession();
		VocabularyMapperOld mapper = session
				.getMapper(VocabularyMapperOld.class);

		Vocabulary checkLogin = mapper.checkLoginByMap(
				MapperMap.put("id", "v_yellow").put("v", "yellow"));

		Debug.test(this, checkLogin);
	}

	@Test
	public void testQueryByIDToMap() {
		SqlSession session = sf.openSession();
		VocabularyMapperOld mapper = session
				.getMapper(VocabularyMapperOld.class);

		Map<String, String> map = mapper.queryByIDtoMap("v_yellow");

		Debug.test(this, map);
	}

	@Test
	public void testQueryAllToMap() {
		SqlSession session = sf.openSession();
		VocabularyMapperOld mapper = session
				.getMapper(VocabularyMapperOld.class);

		//List<Map<String, String>> maps = mapper.queryAlltoMap();
		Map<String, String> maps = mapper.queryAlltoMap();

		Debug.test(this, maps);
	}

	@Test
	public void testQueryByLike() {
		SqlSession session = sf.openSession();
		VocabularyMapperOld mapper = session
				.getMapper(VocabularyMapperOld.class);
		// %' or translation like 'y
		Map<String, String> maps = mapper
				.queryByLike("%' or translation like 'y");
		logger.info("maps={}", maps);
		logger.info("size={}", maps.size());

	}

	@Test
	public void testInsertCard() {
		SqlSession session = sf.openSession(true);
		CardMapper mapper = session.getMapper(CardMapper.class);
		Card card = new Card();
		card.setName("xxx2");
		card.setUid("u_admin");

		int res = mapper.insertCard(card);
		logger.info("card={}", card);

	}

	@Test
	public void testGetAllVocabulary() {
		SqlSession session = sf.openSession(true);
		FlashcardDao mapper = session.getMapper(FlashcardDao.class);
		List<Flashcard> queryAll = mapper.queryAll();
		logger.info("vocs={}", queryAll);

	}

	@Test	
	public void testMapperUtil() {
		FlashcardDao mapper = MapperUtil.setMapperType(FlashcardDao.class)
				.setAutoCommit().getMapper();

		logger.info("vocs={}", mapper.queryAll());

	}

}
