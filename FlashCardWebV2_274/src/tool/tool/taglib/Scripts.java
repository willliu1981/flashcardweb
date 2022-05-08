package tool.taglib;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Scripts {

	public static String getScript(String name, String body, String... params) {
		String strParams = Stream.of(params).collect(Collectors.joining(","));

		StringBuilder sb = Taglibs.getStringBuilder();
		sb.append(name).append("(");//function name and params begin
		sb.append(strParams).append("){");//params end and body begin
		sb.append(body);//body
		sb.append("}");//function end

		return sb.toString();
	}

}
