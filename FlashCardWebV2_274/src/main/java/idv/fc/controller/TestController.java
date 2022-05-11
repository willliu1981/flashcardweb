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
import idv.taglib.component.facade.FacadeFactory;
import tool.spring.SpringUtil;

@Controller
@RequestMapping(value = "test")
public class TestController extends BaseController {

	@RequestMapping(value = "test1")
	public String test1() {

		return "test/test1";
	}

	@RequestMapping(value = "test2")
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

		return "test/fcManagedTestPage";

	}

}
