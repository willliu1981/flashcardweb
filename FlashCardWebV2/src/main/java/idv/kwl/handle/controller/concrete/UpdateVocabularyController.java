package idv.kwl.handle.controller.concrete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import idv.kwl.handle.controller.VocabularyController;
import idv.kwl.model.proxy.VocabularyProxy;

public class UpdateVocabularyController extends VocabularyController<VocabularyProxy> {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String qFromVid = request.getParameter("from-vid");
		String qToVid = request.getParameter("to-vid");
		String qVoca = request.getParameter("vocabulary");
		String qTrans = request.getParameter("translation");
		String qTag = request.getParameter("tag");

		this.getModel().vid(qToVid).vocabulary(qVoca).translation(qTrans).tag(qTag)
				.update(getDao(), qFromVid);

		System.out.println(this.getClass() + ": ");
		return super.handleRequest(request, response);
	}

}
