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
import idv.fc.model.Status;
import idv.fc.model.dto.FlashcardHolderDTO;
import idv.fc.model.dto.HolderDataDTO;
import idv.fc.service.abstraction.IFlashcardHolderService;
import idv.fc.service.abstraction.IFlashcardService;
import idv.fc.service.abstraction.IHolderDataService;
import idv.fc.service.abstraction.IStatusService;

@Controller
@RequestMapping(value = "quiz")
public class QuizController extends BaseController {
	private String QUIZ = "quiz";

	@Autowired
	IFlashcardService flashcardService;

	@Autowired
	IFlashcardHolderService flashcardHolderService;

	@Autowired
	IHolderDataService holderDataService;

	@Autowired
	private IStatusService statusService;

	/*
	 * 管理 Quiz
	 */
	@RequestMapping(value = "quizManager")
	public String toQuizManager() {
		return QUIZ + "/" + "quizManagedPage.jsp";
	}

	@RequestMapping(value = "{mod}/{detail}/{num}")
	public String quizStart(@PathVariable("mod") String mod,
			@PathVariable("detail") String detail,
			@PathVariable("num") Integer num, Map<String, Object> map) {

		List<HolderDataDTO> all = holderDataService.getAllJoinFH(mod, detail,
				num);

		List<Flashcard> collect = all.stream()
				.map(x -> x.getFlashcardHolderDTO().getFlashcard())
				.collect(Collectors.toList());

		String json = collect.stream().filter(x -> x != null)
				.map(x -> x.getId().toString())
				.collect(Collectors.joining(",", "[", "]"));

		map.put("datas", collect);
		map.put("ids", json);

		return "quiz/quizPlay.jsp";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String toFinish() {

		return "quiz/quizFinish.jsp";
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, String> doFinish(String ids) {

		List<Integer> list = Arrays
				.stream(new Gson().fromJson(ids, Integer[].class))
				.collect(Collectors.toList());

		List<HolderDataDTO> all = holderDataService.getAllJoinFH();

		Stream<HolderDataDTO> stream = all.stream()
				.filter(x -> x.getFlashcardHolderDTO().getFlashcard() != null
						&& list.contains(x.getFlashcardHolderDTO()
								.getFlashcard().getId()));

		stream.forEach(x -> {
			Status status = x.getStatus();
			status.setBeginTimeOfPhase(new Timestamp(new Date().getTime()));
			status.setPhase(status.getPhase() + 1);

			FlashcardHolderDTO flashcardHolderDTO = x.getFlashcardHolderDTO();
			flashcardHolderDTO.setNumberOfQuizTimes(
					flashcardHolderDTO.getNumberOfQuizTimes() + 1);

			Flashcard flashcard = x.getFlashcardHolderDTO().getFlashcard();
			flashcard
					.setNumberOfQuizTimes(flashcard.getNumberOfQuizTimes() + 1);

			this.flashcardService.edit(flashcard);
			this.flashcardHolderService.edit(flashcardHolderDTO);
			this.statusService.edit(status);

		});

		Map<String, String> result = new HashMap<>();
		result.put("code", "1");

		return result;
	}

}
