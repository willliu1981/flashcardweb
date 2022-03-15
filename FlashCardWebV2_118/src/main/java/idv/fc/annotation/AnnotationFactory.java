package idv.fc.annotation;

import java.util.HashMap;
import java.util.Map;

public class AnnotationFactory {
	private static Map<String, String> annotationMapping = new HashMap<>();

	public void setAnnotationMapping(Map<String, String> annotationMapping) {
		AnnotationFactory.annotationMapping = annotationMapping;
	}

	public static String getAnnotationPathString(String name) {
		return annotationMapping.get(name);
	}

}
