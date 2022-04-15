package idv.fc.annotation;

import java.util.HashMap;
import java.util.Map;

public class AnnotationFactory {
	private static Map<String, String> annotationPathMapping = new HashMap<>();

	public void setAnnotationPathMapping(Map<String, String> annotationPathMapping) {
		AnnotationFactory.annotationPathMapping = annotationPathMapping;
	}

	/*
	 * 根據name 取得註釋的class路徑
	 */
	public static String getAnnotationPath(String name) {
		return annotationPathMapping.get(name);
	}

}
