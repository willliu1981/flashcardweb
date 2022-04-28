package idv.fc.mybaties.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;

import idv.fc.dao.FlashcardDao;
import idv.fc.pojo.Vocabulary;
import idv.fc.service.IFlashcardService;
import tool.MapperUtil;

//@ContextConfiguration(locations = { "classpath:springmvc/spring-mybatis.xml" })
public class TestMybatis_Spring {
	private static Logger logger = LoggerFactory
			.getLogger(TestMybatis_Spring.class);

	@Resource
	private IFlashcardService vocabularyService = null;

	private ApplicationContext ac = null;

	@BeforeEach
	public void before() {
		ac = new ClassPathXmlApplicationContext(
				"classpath:springmvc/spring-mybatis.xml");
		vocabularyService = (IFlashcardService) ac
				.getBean("vocabularyService");
	}

	@Test
	public void test1() {
		logger.info("service=" + vocabularyService);
		List<Vocabulary> allVocabulary = vocabularyService.getAll();
		// System.out.println(user.getUserName());  
		// logger.info("值："+user.getUserName());  
		logger.info(JSON.toJSONString(allVocabulary));
	}

	@Test
	public void test2() {
		FlashcardDao mapper = MapperUtil
				.setMapperType(FlashcardDao.class).setAutoCommit()
				.getMapper();
		logger.info(JSON.toJSONString(mapper.queryAll()));
	}

	@Test
	public void run1() {
		//调用方法
		List<Vocabulary> findAllVoc = vocabularyService.getAll();
		logger.info("find:" + findAllVoc);
	}
}
