package idv.kwl.rest;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest")
public class RestApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		return super.getClasses();
	}

}
