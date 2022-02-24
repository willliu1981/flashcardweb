package idv.kwl.handle.controller.concrete;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.Controller;

import idv.kwl.bean.factory.SpringUtil;
import idv.kwl.dao.concrete.VocabularyDao;
import idv.kwl.handle.controller.AttributeController;
import idv.kwl.handle.controller.VocabularyController;
import idv.kwl.model.Vocabulary;

public class UpdateVocabularyController extends VocabularyController<Vocabulary> {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String qVid = request.getParameter("vid");
		String qVoca = request.getParameter("vocabulary");
		String qTrans = request.getParameter("translation");

		this.getModel().setVid("v_" + qVoca.trim());
		this.getModel().setVocabulary(qVoca);
		this.getModel().setTranslation(qTrans);

		this.getDao().update(this.getModel(), qVid);

		System.out.println(this.getClass() + ": ");
		return super.handleRequest(request, response);
	}

}
