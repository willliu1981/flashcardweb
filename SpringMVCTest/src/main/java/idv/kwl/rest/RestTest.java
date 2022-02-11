package idv.kwl.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/resttest")
public class RestTest {

	@Path("query")
	@GET
	@Produces("text/plain")
	public String testrest(@QueryParam("pid") String pid) {
		return "produce id=" + pid;
	}

	@Path("/hello")
	@GET
	@Produces("text/plain")
	public String hello() {
		return "produce id=" + "hello";
	}
}
