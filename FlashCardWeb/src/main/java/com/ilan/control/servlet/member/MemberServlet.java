package com.ilan.control.servlet.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ilan.appinitialization.Config;
import com.ilan.control.dao.user.UserdataDao;
import com.ilan.control.factory.BeanFactory;
import com.ilan.control.factory.FactoryBuilder;
import com.ilan.control.factory.daofactory.DaoFactory;
import com.ilan.control.factory.daofactory.DaoFactoryType;
import com.ilan.control.factory.daofactory.IDaoFactory;
import com.ilan.control.factory.daofactory.user.IUserdataDao;
import com.ilan.model.user.User;
import com.ilan.model.user.Userdata;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet(name = "servlet/MemberServlet", urlPatterns = { "/servlet/MemberServlet" })
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ApplicationContext appFactory1 = new ClassPathXmlApplicationContext(
			Config.config.getConnectionXml());
	ApplicationContext appFactory2 = new ClassPathXmlApplicationContext(
			Config.config.getDaoFactoryXml());
	private DataSource dataSource;
	

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

//		IDaoFactory daoFactory = (DaoFactory) FactoryBuilder.getFactory("daoFactory",
//				IDaoFactory.class);
//		IUserdataDao dao = (IUserdataDao) daoFactory.getDao("userdataDao", IUserdataDao.class);

		// FactoryBuilder.getFactory(getServletInfo(), null)

//		dataSource = appFactory1.getBean("dataSource", DataSource.class);
//
//		dao = (UserdataDao) appFactory2.getBean("userdataDao", IUserdataDao.class);
		// dao.setDataSource(dataSource);
		UserdataDao dao =(UserdataDao) BeanFactory.getBean(DaoFactoryType.USERDATADAO);

		User user = (User) request.getSession().getAttribute("user");

		Userdata data = null;
		try {
			data = dao.queryByID(user.getUserdata_id());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("data", data);

		request.getRequestDispatcher("../member/member.jsp").forward(request, response);
	}

}
