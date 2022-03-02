package idv.kwl.handle.controller.concrete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import idv.kwl.handle.controller.DataProcessController;

public class QueryVocabularyController extends DataProcessController<Object> {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String qID = request.getParameter("vid");

		synchronized (this.getClass()) {
			this.start();
			if (qID == null || qID.equals("")) {
				this.getModelAndView().addObject("list", this.getDao().queryAll());
			} else {
				this.getModelAndView().addObject("model",
						this.getDao().queryById(qID));
			}

			return super.handleRequest(request, response);
		}
	}

}
