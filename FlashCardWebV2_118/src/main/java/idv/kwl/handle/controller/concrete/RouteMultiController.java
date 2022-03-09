package idv.kwl.handle.controller.concrete;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
@RequestMapping(value = "page")
public class RouteMultiController {

	@RequestMapping(value = "vocabulary")
	public String vocabulary() {

		return "vocabulary/vocabulary";
	}

	@RequestMapping(value = "vocabulary/add")
	public String vocabularyAdd() {

		return "vocabulary/create";
	}

	@RequestMapping(value = "vocabulary/update")
	public String vocabularyUpdate() {

		return "vocabulary/update";
	}

	@RequestMapping(value = "vocabulary/delete")
	public String vocabularyDelete() {

		return "vocabulary/delete";
	}

	@RequestMapping(value = "vocabulary/query")
	public String vocabularyQuery() {
		return "vocabulary/query";
	}

	@RequestMapping(value = "card")
	public String card() {

		return "card/card";
	}

	@RequestMapping(value = "card/add")
	public String cardAdd() {

		return "card/create";
	}

	@RequestMapping(value = "card/update")
	public String cardUpdate() {

		return "card/update";
	}

	@RequestMapping(value = "card/delete")
	public String cardDelete() {

		return "card/delete";
	}

	@RequestMapping(value = "card/query")
	public String cardQuery() {
		return "card/query";
	}

	@RequestMapping(value = "exam")
	public String exam() {
		return "exam/exam";
	}

}
