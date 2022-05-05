package idv.fc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.fc.model.Flashcard;
import idv.fc.service.impl.FlashcardServiceImpl;
import tool.Debug;
import tool.spring.SpringUtil;

@Controller
@RequestMapping(value = "test")
public class TestController {

	@RequestMapping(value = "test1")
	public String test1() {

		return "test/test1";
	}
	@RequestMapping(value = "test2")
	public String test2(Map<String,Object> map,HttpServletRequest request) {
		
		FlashcardServiceImpl service = SpringUtil.getBean("flashcardService", FlashcardServiceImpl.class);
		
		Flashcard find = service.getById("7");

		
		
		request.getServletContext().setAttribute("fc", find);
		
		return "test/test6";
	}

}
