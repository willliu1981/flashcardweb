package com.ilan.control.servlet.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ilan.control.dao.factory.DaoFactory;
import com.ilan.control.dao.factory.user.AbstractUserDao;
import com.ilan.control.dao.user.UserDao;
import com.ilan.model.user.User;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet(name = "servlet/MemberServlet", urlPatterns = { "/servlet/MemberServlet" })
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ApplicationContext factory=new ClassPathXmlApplicationContext("applicationContext.xml");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		User user =(User) request.getSession().getAttribute("user");
		
		AbstractUserDao dao=factory.getBean("userDao",AbstractUserDao.class);
		User member =dao.findByUsername(user.getUsername());
		
		request.setAttribute("member", member);
		System.out.println();
		request.getRequestDispatcher("../member/member.jsp").forward(request, response);
	}

}
