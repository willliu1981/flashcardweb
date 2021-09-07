package com.ilan.control.servlet.login;

import java.io.IOException;
import java.sql.SQLException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilan.control.factory.BeanFactory;
import com.ilan.control.factory.Factory;
import com.ilan.control.factory.daofactory.DaoFactoryType;
import com.ilan.control.factory.daofactory.user.IUserDao;
import com.ilan.exception.ResultNullException;
import com.ilan.model.user.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		IUserDao<User> dao = (IUserDao<User>) BeanFactory.getBean(DaoFactoryType.USERDAO);

		User user = null;
		boolean identifyFlag = false;
		try {
			identifyFlag = (user = dao.identifyUser(username, password)) != null ? true : false;
		} catch (ResultNullException | SQLException e) {
			System.out.println(e.getMessage());
		}

		if (identifyFlag) {
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("login/loginfailure.jsp").forward(request, response);
		}

	}
}
