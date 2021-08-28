package com.ilan.control.servlet.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilan.control.dao.factory.DaoFactory;
import com.ilan.control.dao.factory.user.UserDaoFactory;

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

		UserDaoFactory daoFactory = (UserDaoFactory) DaoFactory.getUserDaoFactory();
		boolean identifyFlag = daoFactory.identifyUser(username, password);

		if (identifyFlag) {
			
			request.getSession().setAttribute("authority", daoFactory);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("login/loginfailure.jsp").forward(request, response);
		}

	}
}
