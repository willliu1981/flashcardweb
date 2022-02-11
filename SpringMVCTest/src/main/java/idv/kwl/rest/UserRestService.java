package idv.kwl.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("user")
public class UserRestService {

//	@Path("/{pid}")
//	@GET
//	@Produces("text/plain")
//	public String testrest(@PathParam("pid") String pid) {
//		return "query produce id=" + pid;
//	}

	@Path("test")
	@GET
	@Produces("text/plain")
	public String testrest2() {
		return "query produce id=" + "test";
	}

}
