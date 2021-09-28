package test.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flashcard.model.user.User;

import test.injection.UserDaoAdapter;

/**
 * Servlet implementation class TestInjectionServlet
 */
@WebServlet("/test/TestInjectionServlet")
public class TestInjectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestInjectionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserDaoAdapter ap = new UserDaoAdapter();
		User user = null;
		try {
			user = ap.queryByID("uid1631714186150");
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		response.getWriter().append("Served at: ")
				.append(user.getDisplayName());
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
