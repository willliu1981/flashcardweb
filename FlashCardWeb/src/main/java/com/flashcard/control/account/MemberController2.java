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
import com.flashcard.exception.ResultNullException;
import com.flashcard.factory.BeanFactory;
import com.flashcard.factory.Factory;
import com.flashcard.factory.dao.DaoFactoryType;
import com.flashcard.model.ModelWrap;
import com.flashcard.model.UserWrap;
import com.flashcard.model.user.User;
import com.flashcard.model.user.Userdata;
import com.flashcard.security.authority.Authority;
import com.flashcard.security.authority.AuthorityConverter;
import com.flashcard.security.authority.AuthorityFactory;
import com.flashcard.security.authority.AuthorityGroup;
import com.flashcard.security.authorization.AdminAuthorization;
import com.flashcard.tool.Pages;

public class MemberController2 extends Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String page = request.getParameter(name("page"));
		Integer intPage = null;
		if (page == null) {
			intPage = 1;
		} else {
			intPage = Integer.parseInt(page);
		}
		Integer maxPage = Integer.parseInt(name("maxPage"));

		IUserdataDao<Userdata> dao = (IUserdataDao<Userdata>) BeanFactory
				.getBean(DaoFactoryType.USERDATADAO);

		User user = (User) request.getSession(false)
				.getAttribute(Factory.getSessionDefinitionOfName("user"));
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

		AuthorityGroup group = AuthorityFactory
				.createAuthorityGroup(user.getAuthority());
		String groupName = AuthorityFactory.getGroupDefinitionOfName("admin");
		String authName = group.getAuthorityName(groupName);
		String token = (String) group.getAuthority(groupName).getKey(authName);

		if (token.contains(name("tokenReader"))) {
			IUserDao<User> userDao = (IUserDao<User>) BeanFactory
					.getBean(DaoFactoryType.USERDAO);
			IUserdataDao<Userdata> userdataDao = (IUserdataDao<Userdata>) BeanFactory
					.getBean(DaoFactoryType.USERDATADAO);
			int maxData = userDao.count();
			if (Pages.isLast(maxData, intPage, maxPage)) {
				mv.addObject(name("isLast"), true);
			} else if (intPage == 1) {
				mv.addObject(name("isFirst"), true);
			} else {
				mv.addObject(name("isLast"), false);
				mv.addObject(name("isFirst"), false);
			}

			List<User> users = null;
			try {
				users = userDao.findsLimit(intPage, maxPage);
			} catch (ResultNullException e) {
				System.out.println(e.getMessage());
			}

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

			mv.addObject(name("users"), users);
			mv.addObject(name("userdatas"), userdatas);
			mv.addObject(name("page"), intPage);
			mv.addObject(name("maxData"), maxData);
		}
		mv.addObject(name("token"), token);

		return mv;
	}

}
