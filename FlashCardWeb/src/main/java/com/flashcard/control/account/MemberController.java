package com.flashcard.control.account;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.flashcard.control.Controller;
import com.flashcard.dao.IDao;
import com.flashcard.dao.user.IUserDao;
import com.flashcard.dao.user.IUserdataDao;
import com.flashcard.factory.BeanFactory;
import com.flashcard.factory.dao.DaoFactoryType;
import com.flashcard.model.ModelWrap;
import com.flashcard.model.UserWrap;
import com.flashcard.model.user.User;
import com.flashcard.model.user.Userdata;
import com.flashcard.security.authority.AuthorityConverter;
import com.flashcard.security.authority.AuthorityFactory;
import com.flashcard.security.authorization.AdminAuthorization;

public class MemberController extends Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String page = request.getParameter(name("varPage"));
		Integer intPage = null;
		if (page == null) {
			intPage = 1;
		} else {
			intPage = Integer.parseInt(page);
		}
		Integer maxPage = Integer.parseInt(name("valueMaxPage"));

		IUserdataDao<Userdata> dao = (IUserdataDao<Userdata>) BeanFactory
				.getBean(DaoFactoryType.USERDATADAO);

		User user = null;

		user = (User) request.getSession(false).getAttribute(session("user"));
		Userdata data = null;

		try {
			data = dao.queryByID(user.getUserdata_id());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName(target("target"));

		boolean isAdmin = AuthorityFactory.hasKey(user.getAuthority(),
				AuthorityConverter.getGroupNameAdmin(),
				AdminAuthorization.READ_MEMBER_USER);
		if (isAdmin) {
			IUserDao<User> userDao = (IUserDao<User>) BeanFactory
					.getBean(DaoFactoryType.USERDAO);
			IUserdataDao<Userdata> userdataDao = (IUserdataDao<Userdata>) BeanFactory
					.getBean(DaoFactoryType.USERDATADAO);

			List<User> users = userDao.findsLimit(intPage, maxPage);
			List<Userdata> userdatas = new ArrayList<>();

			users.stream().forEach(x -> {
				try {
					Userdata ud = (Userdata) userdataDao
							.queryByID(x.getUserdata_id());
					userdatas.add(ud);
				} catch (IOException | SQLException e) {
					e.printStackTrace();
				}
			});

			mv.addObject(name("varToken"), name("valueTokenAdmin"));
			mv.addObject(name("varUsers"), users);
			mv.addObject(name("varUserdatas"), userdatas);
			mv.addObject(name("varPage"), intPage);
		} else {
			mv.addObject(name("varToken"), name("valueTokenUser"));
		}

		return mv;
	}

}
