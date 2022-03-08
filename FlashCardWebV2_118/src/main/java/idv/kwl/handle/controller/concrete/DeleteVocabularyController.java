package idv.kwl.handle.controller.concrete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import idv.fc.model.Vocabulary;
import idv.kwl.handle.controller.DataProcessController;

public class DeleteVocabularyController extends DataProcessController<Vocabulary> {

	@Override
	public void handleRequestImpl(HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv) throws Exception {
		String qID = request.getParameter("vid");

		this.getDao().delete(qID);
	}

}
