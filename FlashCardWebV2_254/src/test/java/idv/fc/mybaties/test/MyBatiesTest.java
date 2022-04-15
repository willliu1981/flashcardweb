package idv.fc.mybaties.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import idv.fc.mapper.VocabularyMapper;
import tool.Debug;

public class MyBatiesTest {

	@Test
	public void test1() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybaties/mybaties-config.xml");

		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory sf = sfb.build(is);
		SqlSession session = sf.openSession();
		VocabularyMapper mapper = session.getMapper(VocabularyMapper.class);

		int res = mapper.insertVocabulary();

		session.commit();
		Debug.test(this, res);
	}
}
