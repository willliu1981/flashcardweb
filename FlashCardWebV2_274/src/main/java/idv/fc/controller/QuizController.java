package idv.fc.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.fc.model.Flashcard;
import idv.fc.model.dto.QuizDTO;
import idv.fc.service.abstraction.IFlashcardService;

@Controller
@RequestMapping(value = "quiz")
public class QuizController extends BaseController {
	private String QUIZ = "quiz";

	@Autowired
	IFlashcardService flashcardService;

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

		List<Flashcard> all = flashcardService.getAll();
		List<QuizDTO> collect = all.stream().map(item -> new QuizDTO(item))
				.collect(Collectors.toList());

		map.put("datas", collect);
		return "quiz/quizPlay";
	}

}
