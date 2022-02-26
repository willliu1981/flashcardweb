package idv.kwl.handle.controller.concrete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import idv.kwl.handle.controller.DataProcessController;
import idv.kwl.model.Vocabulary;

public class DeleteVocabularyController extends DataProcessController<Vocabulary> {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String qID = request.getParameter("vid");

		this.getDao().delete(qID);

		System.out.println(this.getClass() + ": ");

		return super.handleRequest(request, response);
	}

}
