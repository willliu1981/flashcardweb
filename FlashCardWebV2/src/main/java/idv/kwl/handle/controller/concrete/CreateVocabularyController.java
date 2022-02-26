package idv.kwl.handle.controller.concrete;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import idv.kwl.handle.controller.DataProcessController;
import idv.kwl.model.proxy.VocabularyProxy;

public class CreateVocabularyController extends  DataProcessController<VocabularyProxy> {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		super.handleRequest(request, response);

		String qVoca = request.getParameter("vocabulary");
		String qTrans = request.getParameter("translation");

		this.getModel().vid("v_" + qVoca.trim()).vocabulary(qVoca).translation(qTrans)
				.create_date(Date.valueOf(LocalDate.now())).create(this.getDao());

		System.out.println(this.getClass() + ": ");
		return super.handleRequest(request, response);
	}

}
