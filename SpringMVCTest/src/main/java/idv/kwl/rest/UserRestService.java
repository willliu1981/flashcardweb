package idv.kwl.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import idv.kwl.model.User;
import idv.kwl.model.UserFactory;

@Path("user")
public class UserRestService {

	@Path("/{pid}")
	@GET
	@Produces("text/plain")
	public String testrest(@PathParam("pid") String pid) {
		User u = UserFactory.getUserByID(pid);
		System.out.println("rest test : user =" + u.toString());
		return "query user =" + u.toString();
	}

	@Path("test")
	@GET
	@Produces("text/plain")
	public String testrest2() {
		return "query user id=" + "test";
	}

}
