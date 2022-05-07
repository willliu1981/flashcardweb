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
import idv.fc.taglib.component.listgroup.ListGroup;
import idv.fc.taglib.component.listgroup.listmodel.DefaultListGroupModel;
import idv.fc.taglib.component.listgroup.renderer.ListGroupRenderer;
import idv.fc.taglib.component.listgroup.renderer.impl.FlashcardListGroupRenderer;
import tool.spring.SpringUtil;

@Controller
@RequestMapping(value = "test")
public class TestController {

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

		DefaultListGroupModel<Flashcard> model = new DefaultListGroupModel<>();
		finds.stream().forEach(item -> model.addItem(item));
		ListGroup<Flashcard> listGroup = new ListGroup<>(request);
		listGroup.setModel(model);

		FlashcardListGroupRenderer renderer = new FlashcardListGroupRenderer();
		listGroup.setRenderer(renderer);

		request.getServletContext().setAttribute("datas", finds);
		request.getServletContext().setAttribute("lg", listGroup);

		return "test/fcManagedTestPage";

	}

}
