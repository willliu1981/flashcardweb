package test;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flashcard.factory.BeanFactory;
import com.flashcard.security.authority.AdminAuthority2;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(name = "servlet/TestServlet", urlPatterns = {
		"/servlet/TestServlet" })
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		AdminAuthority2 a = BeanFactory.getBean("adminAuthority2",
				AdminAuthority2.class);

		response.getWriter().append("Served at: ")
				.append(a.getAuthorityKey(AdminAuthority2.Type.ADMIN));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
