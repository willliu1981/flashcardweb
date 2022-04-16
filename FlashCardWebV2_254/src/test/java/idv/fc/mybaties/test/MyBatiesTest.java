package idv.fc.mybaties.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import idv.fc.mybatis.mapper.VocabularyMapper;
import idv.fc.pojo.Vocabulary;
import tool.Debug;

public class MyBatiesTest {
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
		VocabularyMapper mapper = session.getMapper(VocabularyMapper.class);

		int res = mapper.insertVocabulary();

		//session.commit();
		Debug.test(this, res);
	}

	@Test
	public void testUpdate() throws IOException {

		SqlSession session = sf.openSession(true);
		VocabularyMapper mapper = session.getMapper(VocabularyMapper.class);

		int res = mapper.updateVocabulary();

		Debug.test(this, res);
	}

	@Test
	public void testQueryByID() throws IOException {

		SqlSession session = sf.openSession(true);
		VocabularyMapper mapper = session.getMapper(VocabularyMapper.class);

		Vocabulary queryByID = mapper.queryByID("v_yellow");

		Debug.test(this, queryByID);
	}

	//*	

	@Test
	public void testQueryAll() throws IOException {
		SqlSession session = sf.openSession();
		VocabularyMapper mapper = session.getMapper(VocabularyMapper.class);

		List<Vocabulary> allVocabulary = mapper.getAllVocabulary();

		Debug.test(this, allVocabulary);
	}//*/

	@Test
	public void testCheck() {
		SqlSession session = sf.openSession();
		VocabularyMapper mapper = session.getMapper(VocabularyMapper.class);

		Vocabulary checkLogin = mapper.checkLogin("v_yellow", "yellow");

		Debug.test(this, checkLogin);
	}

	@Test
	public void testCheckByMap() {
		SqlSession session = sf.openSession();
		VocabularyMapper mapper = session.getMapper(VocabularyMapper.class);

		Map<String, String> map = new HashMap<>();
		map.put("id", "v_yellow");
		map.put("v", "yellow");

		Vocabulary checkLogin = mapper.checkLoginByMap(map);

		Debug.test(this, checkLogin);
	}
}
