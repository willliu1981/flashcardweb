package test;

import java.io.IOException;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilan.control.dao.user.UserDao;

/**
 * Servlet implementation class TestJNDIServlet
 */
@WebServlet("/TestJNDIServlet")
public class TestJNDIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestJNDIServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// *
		Context initCtx;
		try {
			Context ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:comp/env");

			final Book book = (Book) env.lookup("bean/Book");

			response.getWriter().append(" book : " + book.getBookName());

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
