package idv.kwl.handle.controller.concrete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import idv.kwl.handle.controller.DataProcessController;

public class QueryVocabularyController extends DataProcessController<Object> {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		this.start();
		
		String qID = request.getParameter("vid");

		synchronized (this.getClass()) {
			if (qID == null || qID.equals("")) {
				this.getModelAndView().addObject("list", this.getDao().queryAll());
			} else {
				this.getModelAndView().addObject("vocabulary",
						this.getDao().queryById(qID));
			}
			System.out.println(this.getClass() + ":" + qID);

			return super.handleRequest(request, response);
		}
	}

}
