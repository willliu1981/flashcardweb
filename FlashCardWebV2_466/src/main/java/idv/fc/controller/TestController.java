package idv.fc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import idv.fc.model.Flashcard;
import idv.fc.model.dto.QuizDTO;
import idv.fc.service.abstraction.IFlashcardService;
import idv.fc.service.impl.FlashcardServiceImpl;
import tool.spring.SpringUtil;

@Controller
@RequestMapping(value = "test")
public class TestController extends BaseController {

	@RequestMapping(value = "test1")
	public String test1() {

		return "redirect:/flashcards/fcManager";
	}
	
	@RequestMapping(value = "test1_1")
	public String test1_1() {
		
		return "redirect:WEB-INF/view/test/testx.html";
	}

	@RequestMapping(value = "test2", produces = "application/json")
	@ResponseBody
	public Map<String, Object> test2(Map<String, Object> map1) {
		Map<String, Object> map = new HashMap<>();
		Gson g = new Gson();
		IFlashcardService service = SpringUtil.getBean("flashcardService",
				FlashcardServiceImpl.class);

		List<Flashcard> datas = service.getAll();

		map.put("datas", datas);
		map.put("msg", "xxxabc");

		return map;
	}

	

	@RequestMapping(value = "test4")
	public String test3(Map<String, Object> map) {

		IFlashcardService service = SpringUtil.getBean("flashcardService",
				FlashcardServiceImpl.class);

		List<Flashcard> datas = service.getAll();

		List<QuizDTO> collect = datas.stream().map(item -> new QuizDTO(item))
				.collect(Collectors.toList());

		map.put("datas", collect);
		return "test/test7";
	}

}
