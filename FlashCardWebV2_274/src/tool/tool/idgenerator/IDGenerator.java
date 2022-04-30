package tool.idgenerator;

import java.util.Map;
import java.util.UUID;

public class IDGenerator {

	private String defaultIdPrefix;
	private String defaultSeparator;
	private Map<Class, String> IdMappings;

	public void setIdMappings(Map<Class, String> idMappings) {
		IdMappings = idMappings;
	}

	public void setDefaultIdPrefix(String defaultIdPrefix) {
		this.defaultIdPrefix = defaultIdPrefix;
	}

	public void setDefaultSeparator(String defaultSeparator) {
		this.defaultSeparator = defaultSeparator;
	}

	public String generate(String id, Class<?> modelType) {
		String idPrefix = null;
		if (modelType == null) {
			idPrefix = defaultIdPrefix;
		} else {
			idPrefix = IdMappings.get(modelType);
		}

		return idPrefix + defaultSeparator + id + UUID.randomUUID();
	}

	public String generate(String id) {

		return generate(null);
	}

}
