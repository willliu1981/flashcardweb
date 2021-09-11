package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flashcard.application.config.AppConfig;
import com.flashcard.factory.BeanFactory;
import com.flashcard.security.authority.AdminAuthority;
import com.flashcard.security.authority.Authority;
import com.flashcard.security.authorization.AdminAuthorization;
import com.flashcard.security.authorization.Authorizations;

/**
 * Servlet implementation class TestAuthority
 */
@WebServlet("/TestAuthority")
public class TestAuthority extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestAuthority() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Authority auth = (Authority) BeanFactory.getApplicationContext(
				AppConfig.config.getFactoryConfig().getXmlRootReferer() + "interception.xml")
				.getBean("authority");

		int key = auth.getAuthorityKey(AdminAuthority.ADMIN);
		System.out.println("keyyyyyyy " + key);
		
		boolean r=Authorizations.hasKey(key, AdminAuthorization.DELETE_MEMBER_USER);
		System.out.println("keyyyyyyy2 " + r);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
