package com.flashcard.control.account;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.flashcard.dao.IDao;
import com.flashcard.dao.user.IUserdataDao;
import com.flashcard.factory.BeanFactory;
import com.flashcard.factory.dao.DaoFactoryType;
import com.flashcard.model.user.User;
import com.flashcard.model.user.Userdata;
import com.flashcard.security.authority.AdminAuthority;
import com.flashcard.security.authority.AuthorityFactory;
import com.flashcard.security.authorization.AdminAuthorization;

public class MemberController implements Controller {
	private String viewPageTarget;
	private String sessionNameUser = "user";
	private String nameUsers = "users";
	private String nameUserdatas = "userdatas";
	private String nameToken = "token";
	private String valueTokenValueUser = "tokenUser";
	private String valueTokenValueEditer = "tokenEditer";
	private String valueTokenValueAdmin = "tokenAdmin";

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
		String token=valueTokenValueUser;

		boolean isAdmin = AuthorityFactory.hasKey(user.getAuthority(), "admin",
				AdminAuthorization.READ_MEMBER_USER);
		if (isAdmin) {
			System.out.println("membercontroller *** " + user.getAuthority());
			IDao<?> userDao= BeanFactory.getBean(DaoFactoryType.USERDAO);
			List<?> users=userDao.queryAll();
			mv.addObject(nameUsers,users);
			//mv.addObject(nameUserdatas,null);
			token=valueTokenValueAdmin;
			
		}else {
		}
		mv.addObject(nameToken,token);

		return mv;
	}

	public void setViewPageTarget(String viewPageTarget) {
		this.viewPageTarget = viewPageTarget;
	}

	public void setNameUsers(String nameUsers) {
		this.nameUsers = nameUsers;
	}

	public void setNameUserdatas(String nameUserdatas) {
		this.nameUserdatas = nameUserdatas;
	}

	public void setNameToken(String nameToken) {
		this.nameToken = nameToken;
	}

	public void setValueTokenValueUser(String valueTokenValueUser) {
		this.valueTokenValueUser = valueTokenValueUser;
	}

	public void setValueTokenValueAdmin(String valueTokenValueAdmin) {
		this.valueTokenValueAdmin = valueTokenValueAdmin;
	}

	public void setSessionNameUser(String sessionNameUser) {
		this.sessionNameUser = sessionNameUser;
	}

	public void setValueTokenValueEditer(String valueTokenValueEditer) {
		this.valueTokenValueEditer = valueTokenValueEditer;
	}

}
