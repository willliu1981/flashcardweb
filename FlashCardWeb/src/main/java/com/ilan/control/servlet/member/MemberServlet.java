package com.ilan.control.servlet.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ilan.control.dao.user.UserDao;
import com.ilan.control.factory.Factory;
import com.ilan.control.factory.daofactory.DaoFactory;
import com.ilan.control.factory.daofactory.IDaoFactory;
import com.ilan.control.factory.daofactory.user.IUserDao;
import com.ilan.control.factory.daofactory.user.IUserdataDao;
import com.ilan.model.user.User;
import com.ilan.model.user.Userdata;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet(name = "servlet/MemberServlet", urlPatterns = { "/servlet/MemberServlet" })
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IDaoFactory daoFactory = (DaoFactory) Factory.getFactory("daoFactory", IDaoFactory.class);
		IUserdataDao dao = (IUserdataDao) daoFactory.getDao("userdataDao", IUserdataDao.class);

		User user = (User) request.getSession().getAttribute("user");

		Userdata data = dao.queryByID(user.getUserdata_id());

		request.setAttribute("data", data);

		request.getRequestDispatcher("../member/member.jsp").forward(request, response);
	}

}
