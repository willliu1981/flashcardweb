package tool.taglib;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

public class Scripts {

	public static String getScript(String name, String... params) {
		String strParams = Stream.of(params).map(x -> "'" + x + "'")
				.collect(Collectors.joining(","));

		StringBuilder sb = Taglibs.getStringBuilder();
		sb.append(name).append("(").append(strParams).append(")");

		return sb.toString();
	}

	public static String getScriptWithHref(String contextPath,
			String... pathVariables) {
		String pv = Stream.of(pathVariables).collect(Collectors.joining("/"));

		StringBuilder sb = Taglibs.getStringBuilder();
		sb.append("location.href='").append(contextPath)
				.append("/");
		sb.append(pv);
		sb.append("'");
		return sb.toString();
	}

	public static String getScriptWithBody(String name, String body,
			String... params) {

		return null;
	}

}
