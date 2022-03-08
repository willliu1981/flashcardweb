package idv.kwl.handle.controller.concrete;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import idv.fc.model.proxy.VocabularyProxy;
import idv.kwl.handle.controller.DataProcessController;

public class CreateVocabularyController extends DataProcessController<VocabularyProxy> {

	@Override
	public void handleRequestImpl(HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv) throws Exception {
		String qVoca = request.getParameter("vocabulary");
		String qTrans = request.getParameter("translation");

		this.getModel().vid("v_" + qVoca.trim()).vocabulary(qVoca).translation(qTrans)
				.create_date(Date.valueOf(LocalDate.now())).create(this.getDao());
	}

}
