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
import idv.fc.model.Flashcard;
import idv.fc.pojo.Vocabulary;
import idv.fc.service.IFlashcardService;
import tool.MapperUtil;

//@ContextConfiguration(locations = { "classpath:springmvc/spring-mybatis.xml" })
public class TestMybatis_Spring {
	private static Logger logger = LoggerFactory
			.getLogger(TestMybatis_Spring.class);

	@Resource
	private IFlashcardService flashcardService = null;

	private ApplicationContext ac = null;

	@BeforeEach
	public void before() {
		ac = new ClassPathXmlApplicationContext(
				"classpath:springmvc/spring-mybatis.xml");
		flashcardService = (IFlashcardService) ac
				.getBean("flashcardService");
	}

	@Test
	public void test1() {
		logger.info("service=" + flashcardService);
		List<Flashcard> allVocabulary = flashcardService.getAll();
		// System.out.println(user.getUserName());  
		// logger.info("值："+user.getUserName());  
		logger.info("xxx:"+JSON.toJSONString(allVocabulary));
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
		List<Flashcard> findAllVoc = flashcardService.getAll();
		logger.info("find:" + findAllVoc);
	}
}
