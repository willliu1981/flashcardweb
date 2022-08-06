package spring;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class XmlUrlFactory {

	private static Properties defaultXmlUrlSet;
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
			String defaultKey;
			if (key.equals(defaultKey = defaultXmlUrlSet.getProperty(key))) {
				key = defaultKey;
			}
			arr = xmlUrls.get(key).toArray(new String[xmlUrls.get(key).size()]);
		}

		return arr;
	}

	public static void setDefaultXmlUrlSet(Properties defaultXmlUrlSet) {
		XmlUrlFactory.defaultXmlUrlSet = defaultXmlUrlSet;
	}

}
