package idv.fc.controller;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import idv.debug.Debug;
import idv.fc.model.Flashcard;
import idv.fc.model.dto.HolderDataDTO;
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
		return QUIZ + "/" + "quizManagedPage.jsp";
	}

	@RequestMapping(value = "{mod}/{num}")
	public String quizStart(@PathVariable("mod") String mod,
			@PathVariable("num") Integer num, Map<String, Object> map) {

		List<HolderDataDTO> all = holderDataService.getAllJoinFH(mod, num);

		List<Flashcard> collect = all.stream()
				.map(x -> x.getFlashcardHolderDTO().getFlashcard())
				.collect(Collectors.toList());

		String json = collect.stream().map(x -> x.getId().toString())
				.collect(Collectors.joining(",", "[", "]"));

		map.put("datas", collect);
		map.put("ids", json);

		return "quiz/quizPlay.jsp";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String toFinish() {
		Debug.test(new Object() {
		}, "xxxx2");
		return "quiz/quizFinish.jsp";
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, String> doFinish(String ids) {

		List<Integer> list = Arrays
				.stream(new Gson().fromJson(ids, Integer[].class))
				.collect(Collectors.toList());

		List<HolderDataDTO> all = holderDataService.getAllJoinFH();

		Stream<HolderDataDTO> stream = all.stream().filter(x -> list
				.contains(x.getFlashcardHolderDTO().getFlashcard().getId()));

		stream.forEach(x -> {
			x.getStatus()
					.setBeginTimeOfPhase(new Timestamp(new Date().getTime()));
			x.getStatus().setPhase(x.getStatus().getPhase() + 1);

			x.getFlashcardHolderDTO().setNumberOfQuizTimes(
					x.getFlashcardHolderDTO().getNumberOfQuizTimes() + 1);

			x.getFlashcardHolderDTO().getFlashcard()
					.setNumberOfQuizTimes(x.getFlashcardHolderDTO()
							.getFlashcard().getNumberOfQuizTimes() + 1);

		});

		Map<String, String> result = new HashMap<>();
		result.put("code", "1");

		Debug.test(new Object() {
		}, "xxxx");

		return result;
	}

}
