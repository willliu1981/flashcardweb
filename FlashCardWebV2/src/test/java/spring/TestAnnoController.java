package spring;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idv.kwl.model.proxy.IVocabulary;

@Controller
@RequestMapping("spring")
public class TestAnnoController {

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String test1(HashMap model, IVocabulary voca) {
		model.put("a", voca.getVocabulary());
		model.put("b", voca.getTranslation());

		System.out.println(this.getClass() + " :test1 ");
		return "testresult";
	}

}
