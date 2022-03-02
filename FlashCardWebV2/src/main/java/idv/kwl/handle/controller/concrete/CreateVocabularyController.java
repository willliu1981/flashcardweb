package idv.kwl.handle.controller.concrete;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import idv.kwl.handle.controller.DataProcessController;
import idv.kwl.model.proxy.VocabularyProxy;

public class CreateVocabularyController extends DataProcessController<VocabularyProxy> {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String qVoca = request.getParameter("vocabulary");
		String qTrans = request.getParameter("translation");
		synchronized (this.getClass()) {
			this.start();
			this.getModel().vid("v_" + qVoca.trim()).vocabulary(qVoca)
					.translation(qTrans).create_date(Date.valueOf(LocalDate.now()))
					.create(this.getDao());

			return super.handleRequest(request, response);
		}
	}

}
