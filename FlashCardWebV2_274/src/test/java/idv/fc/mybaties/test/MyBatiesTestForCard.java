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

import idv.fc.mybatis.mapper.CardMapper;
import idv.fc.mybatis.mapper.VocabularyMapperOld;
import idv.fc.pojo.Card;
import idv.fc.pojo.Vocabulary;
import tool.Debug;
import tool.MapperMap;

public class MyBatiesTestForCard {
	private final static Logger logger = LoggerFactory
			.getLogger(MyBatiesTestForCard.class);
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
	public void testQueryByID() throws IOException {

		SqlSession session = sf.openSession(true);
		CardMapper mapper = session.getMapper(CardMapper.class);

		Card queryByID = mapper.queryByIdByStep(20);

		Debug.test(this, queryByID);



	}

}
