package idv.fc.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.debug.Debug;
import idv.fc.model.Flashcard;
import idv.fc.model.dto.HolderDataDTO;
import idv.fc.model.dto.QuizDTO;
import idv.fc.service.abstraction.IFlashcardService;
import idv.fc.service.abstraction.IHolderDataService;

@Controller
@RequestMapping(value = "quiz")
public class QuizController extends BaseController {
	private String QUIZ = "quiz";

	@Autowired
	IHolderDataService holderDataService;

	/*
	 * 管理 Quiz
	 */
	@RequestMapping(value = "quizManager")
	public String toQuizManager() {
		return QUIZ + "/" + "quizManagedPage";
	}

	@RequestMapping(value = "{mod}/{num}")
	public String quizStart(@PathVariable("mod") String mod,
			@PathVariable("num") Integer num, Map<String, Object> map) {

		List<HolderDataDTO> all = holderDataService.getAllJoinFH(mod, num);

		Debug.test(new Object() {
		}, "datas", all);

		map.put("datas", all);
		return "quiz/quizPlay";
	}

}
