package idv.fc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import idv.fc.model.Flashcard;
import idv.fc.service.impl.FlashcardServiceImpl;
import idv.fc.taglib.impl.list.flashcard.FlashcardListFacade;
import idv.taglib.factory.FacadeFactory;
import tool.spring.SpringUtil;

@Controller
@RequestMapping(value = "test")
public class TestController extends BaseController {

	@RequestMapping(value = "test1")
	public String test1() {

		return "test/test1";
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
	public String test3(Map<String, Object> map, HttpServletRequest request) {

		FlashcardServiceImpl service = SpringUtil.getBean("flashcardService",
				FlashcardServiceImpl.class);

		List<Flashcard> datas = service.getAll();

		/*		List<QuizDTO> collect = datas.stream().map(item -> new QuizDTO(item))
						.collect(Collectors.toList());
		
				Debug.test(new Object() {
				}, collect);
		*/

		request.setAttribute("datas", datas);
		//map.put("datas", datas);
		//map.put("dd", collect.get(0));
		return "test/test8";
	}

}
