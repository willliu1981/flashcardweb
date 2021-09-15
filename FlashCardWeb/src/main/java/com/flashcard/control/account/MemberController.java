package com.flashcard.control.account;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.flashcard.dao.IDao;
import com.flashcard.dao.user.IUserdataDao;
import com.flashcard.factory.BeanFactory;
import com.flashcard.factory.dao.DaoFactoryType;
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
			IDao<?> userDao = BeanFactory.getBean(DaoFactoryType.USERDAO);
			IDao<?> userdataDao = BeanFactory
					.getBean(DaoFactoryType.USERDATADAO);
			List<?> users = userDao.queryAll();
			List<?> userdatas = userdataDao.queryAll();
			List<UserWrap> userWraps = new ArrayList<>();
			users.forEach(x -> {
				UserWrap wrap = BeanFactory.getBean("userWrap", UserWrap.class);
				
				wrap.addObject("user", x);
				Userdata d = (Userdata) userdatas.stream().filter(y -> true)
						.findFirst().get();
				wrap.addObject("userdata", d);
				userWraps.add(wrap);
			});
			mv.addObject(name("varToken"), name("valueTokenAdmin"));
			mv.addObject(name("varUsers"), userWraps);
		} else {
			mv.addObject(name("varToken"), name("valueTokenUser"));
		}

		return mv;
	}

}
