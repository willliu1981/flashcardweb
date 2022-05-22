package idv.fc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

import idv.fc.model.Flashcard;
import idv.fc.model.dto.QuizDTO;
import idv.fc.service.impl.FlashcardServiceImpl;
import idv.fc.taglib.impl.list.flashcard.FlashcardListFacade;
import idv.taglib.factory.FacadeFactory;
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
		FlashcardServiceImpl service = SpringUtil.getBean("flashcardService",
				FlashcardServiceImpl.class);

		List<Flashcard> datas = service.getAll();

		map.put("datas", datas);
		map.put("msg", "xxxabc");

		return map;
	}

	@RequestMapping(value = "test3")
	public String test2(Map<String, Object> map, HttpServletRequest request) {

		FlashcardServiceImpl service = SpringUtil.getBean("flashcardService",
				FlashcardServiceImpl.class);

		PageHelper.startPage(1, 5);
		List<Flashcard> datas = service.getAll();
		PageInfo<Flashcard> pageInfo = new PageInfo<>(datas, 5);
		map.put("pageInfo", pageInfo);

		FlashcardListFacade facade = FacadeFactory.getListFacade(datas,
				FlashcardListFacade.class);

		request.getServletContext().setAttribute("facade", facade);
		Flashcard flashcard = datas.get(0);
		map.put("command", flashcard);
		return "test/test7";

	}

	@RequestMapping(value = "test4")
	public String test3(Map<String, Object> map) {

		FlashcardServiceImpl service = SpringUtil.getBean("flashcardService",
				FlashcardServiceImpl.class);

		List<Flashcard> datas = service.getAll();

		List<QuizDTO> collect = datas.stream().map(item -> new QuizDTO(item))
				.collect(Collectors.toList());

		map.put("datas", collect);
		return "test/test7";
	}

}