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
import idv.fc.taglib.component.ListFacade;
import idv.fc.taglib.component.listgroup.ListGroup;
import idv.fc.taglib.component.listgroup.listmodel.DefaultListGroupModel;
import idv.fc.taglib.component.listgroup.renderer.impl.FlashcardListGroupRenderer;
import idv.fc.taglib.component.modal.Modal;
import idv.fc.taglib.component.modal.renderer.impl.FlashcardDeleteModalRenderer;
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
		List<Flashcard> finds = service.getAll();
		PageInfo<Flashcard> pageInfo = new PageInfo<>(finds, 5);
		map.put("pageInfo", pageInfo);

		//ListGroup begin
		ListGroup<Flashcard> listGroup = new ListGroup<>();
		DefaultListGroupModel<Flashcard> model = new DefaultListGroupModel<>();
		finds.stream().forEach(item -> model.addItem(item));
		FlashcardListGroupRenderer fclgRenderer = new FlashcardListGroupRenderer(
				request);

		listGroup.setModel(model);
		listGroup.setRenderer(fclgRenderer);

		//request.getServletContext().setAttribute("listGroup", listGroup);
		//ListGroup end

		//Modal begin
		Modal<Flashcard> modal = new Modal<>();
		FlashcardDeleteModalRenderer fcdmRenderer = new FlashcardDeleteModalRenderer(
				request);
		modal.setRenderer(fcdmRenderer);

		//request.getServletContext().setAttribute("modal", modal);
		//Modal end

		ListFacade<Flashcard> fcFacade = new ListFacade<>(listGroup, modal);
		request.getServletContext().setAttribute("fcFacade", fcFacade);

		return "test/fcManagedTestPage";

	}

}
