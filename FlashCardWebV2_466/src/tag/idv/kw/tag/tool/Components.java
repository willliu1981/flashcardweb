package idv.kw.tag.tool;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Components {
	public static String getHtmlClasses(List<String> datas) {
		return datas.stream()
				.collect(Collectors.joining(" ", " class=\"", "\""));
	}

	public static String getStyleSheets(List<String> datas) {
		return datas.stream()
				.collect(Collectors.joining(";", "style=\"", "\""));
	}

	public static String getAttributes(Map<String, String> datas) {
		return datas.entrySet().stream()
				.map(es -> es.getKey() + "=\"" + es.getValue() + "\"")
				.collect(Collectors.joining(" "));
	}

	public static String getScripts(List<String> datas) {

		return datas.stream().collect(Collectors.joining());
	}
}
