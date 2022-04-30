package tool.idgenerator;

import java.util.Map;
import java.util.UUID;

import tool.Debug;

public class IDGenerator {

	private String defaultIdPrefix;
	private String defaultSeparator;
	private Map<String, String> IdMappings;

	public void setIdMappings(Map<String, String> idMappings) {
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
			String value;
			if ((value = IdMappings.get(modelType.getName())) != null) {
				idPrefix = value;
			}
		}

		return idPrefix + defaultSeparator + id + defaultSeparator
				+ UUID.randomUUID();
	}

	public String generate(String id) {

		return generate(id, null);
	}

}
