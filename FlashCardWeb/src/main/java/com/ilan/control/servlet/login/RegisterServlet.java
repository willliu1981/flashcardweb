package com.ilan.control.servlet.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilan.control.authority.Authorities;
import com.ilan.control.authority.Authority;
import com.ilan.control.dao.user.UserDao;
import com.ilan.control.dao.user.UserdataDao;
import com.ilan.control.factory.BeanFactory;
import com.ilan.control.factory.daofactory.DaoFactoryType;
import com.ilan.model.user.User;
import com.ilan.model.user.Userdata;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String displayname = request.getParameter("displayname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		String serial_id = "" + new java.util.Date().getTime();
		String user_id = "uid" + serial_id;
		String userdata_id = "udid" + serial_id;
		
		

		boolean isSucceed = true;

		User user = new User();
		user.setU_id(user_id);
		user.setUsername(username);
		user.setPassword(password);
		user.setDisplayName(displayname);
		user.setUserdata_id(userdata_id);
		user.setAuthority(Authorities.toString(Authorities.getDefaultAuthority()));

		UserDao userDao = (UserDao) BeanFactory.getBean(DaoFactoryType.USERDAO);
		if (!userDao.add(user)) {
			isSucceed = false;
		}

		Userdata userdata = new Userdata();
		userdata.setUd_id(userdata_id);
		userdata.setUser_id(user_id);
		userdata.setName(user.getDisplayName());
		userdata.setEmail(email);

		UserdataDao userdataDao = (UserdataDao) BeanFactory.getBean(DaoFactoryType.USERDATADAO);
		try {
			if (!userdataDao.add(userdata)) {
				isSucceed = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (isSucceed) {
			request.getRequestDispatcher("login/login.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("login/registerfailure.jsp").forward(request, response);
		}

	}

}
