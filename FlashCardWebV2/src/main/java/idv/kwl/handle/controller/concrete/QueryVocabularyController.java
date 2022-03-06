package idv.kwl.handle.controller.concrete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import idv.kwl.handle.controller.DataProcessController;

public class QueryVocabularyController extends DataProcessController<Object> {

	@Override
	public void handleRequestImpl(HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv) throws Exception {

		String qID = request.getParameter("vid");

		this.start();
		if (qID == null || qID.equals("")) {
			mv.addObject("list", this.getDao().queryAll());
		} else {
			mv.addObject("model", this.getDao().queryById(qID));
		}

	}

}
