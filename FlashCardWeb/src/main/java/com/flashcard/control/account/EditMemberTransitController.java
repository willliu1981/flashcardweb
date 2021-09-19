package com.flashcard.control.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.flashcard.control.Controller;
import com.flashcard.dao.user.IUserDao;
import com.flashcard.dao.user.IUserdataDao;
import com.flashcard.factory.BeanFactory;
import com.flashcard.factory.dao.DaoFactoryType;
import com.flashcard.model.user.User;
import com.flashcard.model.user.Userdata;

public class EditMemberTransitController extends Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView mv = new ModelAndView();
		mv.setViewName(target("target"));
		return mv;
	}

}
