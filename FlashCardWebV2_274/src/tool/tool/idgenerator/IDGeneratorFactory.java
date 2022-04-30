package tool.idgenerator;

import java.util.Map;

import org.springframework.beans.factory.FactoryBean;

public class IDGeneratorFactory implements FactoryBean<IDGenerator> {

	private Map<Class, String> idMappings;
	private String defaultIdPrefix= "ID";
	private String defaultSeparator = "_";

	@Override
	public IDGenerator getObject() throws Exception {
		IDGenerator gen = new IDGenerator();
		gen.setIdMappings(idMappings);
		gen.setDefaultIdPrefix(defaultIdPrefix);
		gen.setDefaultSeparator(defaultSeparator);
		return gen;
	}

	@Override
	public Class<IDGenerator> getObjectType() {
		return IDGenerator.class;
	}

	public void setIdMappings(Map<Class, String> idMappings) {
		this.idMappings = idMappings;
	}


	public void setDefaultIdPrefix(String defaultIdPrefix) {
		this.defaultIdPrefix = defaultIdPrefix;
	}

	public void setDefaultSeparator(String defaultSeparator) {
		this.defaultSeparator = defaultSeparator;
	}



	

}
