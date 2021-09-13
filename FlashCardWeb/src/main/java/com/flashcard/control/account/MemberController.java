package com.flashcard.control.account;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.flashcard.dao.user.IUserdataDao;
import com.flashcard.factory.BeanFactory;
import com.flashcard.factory.dao.DaoFactoryType;
import com.flashcard.model.user.User;
import com.flashcard.model.user.Userdata;
import com.flashcard.security.authority.AdminAuthority;
import com.flashcard.security.authority.AuthorityFactory;

public class MemberController implements Controller {
	private String viewPageTarget;
	private String sessionNameUser = "user";
	private String sessionNameUserdata = "userdata";

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// IUserdataDao<Userdata> dao = (IUserdataDao<Userdata>)
		// BeanFactory.getBean(DaoFactoryType.USERDATADAO);

		IUserdataDao<Userdata> dao = (IUserdataDao<Userdata>) BeanFactory
				.getBean(DaoFactoryType.USERDATADAO);

		User user = null;

		user = (User) request.getSession(false).getAttribute(sessionNameUser);
		Userdata data = null;

		try {
			data = dao.queryByID(user.getUserdata_id());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName(viewPageTarget);
		mv.addObject(sessionNameUser, user);
		mv.addObject(sessionNameUserdata, data);

		boolean isAdmin = AuthorityFactory.hasKey(user.getAuthority(), "admin",
				AdminAuthority.EDITOR);
		if (isAdmin) {
			System.out.println("membercontroller *** " + user.getAuthority());

		}

		return mv;
	}

	public void setViewPageTarget(String viewPageTarget) {
		this.viewPageTarget = viewPageTarget;
	}

	public void setSessionNameUser(String sessionNameUser) {
		this.sessionNameUser = sessionNameUser;
	}

	public void setSessionNameUserdata(String sessionNameUserdata) {
		this.sessionNameUserdata = sessionNameUserdata;
	}

}
