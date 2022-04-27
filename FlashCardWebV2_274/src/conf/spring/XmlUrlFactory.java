package spring;

import java.util.List;
import java.util.Map;

public class XmlUrlFactory {

	private static Map<String, List<String>> xmlUrls;
	private static String[] arr;

	private XmlUrlFactory() {
		super();
	}

	public Map<String, List<String>> getXmlUrls() {
		return xmlUrls;
	}

	public void setXmlUrls(Map<String, List<String>> xmlUrls) {
		this.xmlUrls = xmlUrls;
	}

	public static String[] getUrls(String key) {
		if (arr == null) {
			arr = xmlUrls.get(key).toArray(new String[xmlUrls.size()]);
		}

		return arr;
	}

}
