package idv.kwl.handle.controller.concrete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import idv.kwl.handle.controller.AttributeController;
import idv.kwl.handle.controller.VocabularyController;
import idv.kwl.model.Vocabulary;

public class TestController extends VocabularyController<Vocabulary> {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		this.getModelAndView().addObject("a", "AAA");

		System.out.println(this.getClass() + ": " + this.getDao());
		System.out.println(this.getClass() + ": " + this.getModel());

		return super.handleRequest(request, response);
	}

}
