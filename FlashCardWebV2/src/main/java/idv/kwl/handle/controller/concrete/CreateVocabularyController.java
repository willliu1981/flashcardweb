package idv.kwl.handle.controller.concrete;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import idv.kwl.bean.factory.SpringUtil;
import idv.kwl.dao.concrete.VocabularyDao;
import idv.kwl.handle.controller.VocabularyController;
import idv.kwl.model.Vocabulary;
import idv.kwl.model.proxy.VocabularyProxy;

public class CreateVocabularyController extends VocabularyController<VocabularyProxy> {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		super.handleRequest(request, response);

		String qVoca = request.getParameter("vocabulary");
		String qTrans = request.getParameter("translation");

		this.getModel().setVid("v_" + qVoca.trim());
		this.getModel().setVocabulary(qVoca);
		this.getModel().setTranslation(qTrans);
		this.getModel().setCreate_date(Date.valueOf(LocalDate.now()));

		this.getDao().create(this.getModel());

		System.out.println(this.getClass() + ": ");
		return super.handleRequest(request, response);
	}

}
