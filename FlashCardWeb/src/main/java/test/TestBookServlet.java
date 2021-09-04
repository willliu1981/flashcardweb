package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ilan.control.config.Config;

/**
 * Servlet implementation class TestBookServlet
 */
@WebServlet("/TestBookServlet")
public class TestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ApplicationContext factory=new ClassPathXmlApplicationContext(Config.config.getConnectionXml());
	@Autowired
	Author author;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public TestBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Book book=factory.getBean("book",Book.class);
		book.setAuthor(author);
		
		response.getWriter().append("Served at: book:").append(book.getBookName() +", author:"+book.getAuthor().getName());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
