package idv.kwl.handle.controller.concrete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import idv.kwl.handle.controller.DataProcessController;
import idv.kwl.model.proxy.VocabularyProxy;

public class UpdateVocabularyController extends DataProcessController<VocabularyProxy> {

	@Override
	public void handleRequestImpl(HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv) throws Exception {
		String qFromVid = request.getParameter("from-vid");
		String qToVid = request.getParameter("to-vid");
		String qVoca = request.getParameter("vocabulary");
		String qTrans = request.getParameter("translation");
		String qTag = request.getParameter("tag");

		this.getModel().vid(qToVid).vocabulary(qVoca).translation(qTrans).tag(qTag)
				.update(getDao(), qFromVid);

	}

}
