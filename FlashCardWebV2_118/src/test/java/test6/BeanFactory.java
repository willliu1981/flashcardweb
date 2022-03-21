package test6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory {

	List<BeanBuilderInfo> builderInfos = new ArrayList<>();
	Map<String, Object> instances = new HashMap<>();

	public void configure() {
		createInstance();
		createProperty();
	}

	public void addBuilderInfo(BeanBuilderInfo builder) {
		this.builderInfos.add(builder);
	}

	private void createProperty() {
		this.builderInfos.forEach(x -> {
			Object action = instances.get(x.getId());
			x.getProperties().forEach((p) -> {
				String type = p.getValueType();
				if (type.equals(BaseProperty.BASE)) {
					try {
						Method method = action.getClass().getMethod(p.getName(),
								String.class);
						method.invoke(action, p.getValue());

					} catch (NoSuchMethodException | SecurityException
							| IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
				}

			});

		});
	}

	private void createInstance() {
		this.builderInfos.forEach(x -> {
			try {
				Class<?> clazz = Class.forName(x.getClassString());
				Object instance = clazz.newInstance();
				instances.put(x.getId(), instance);
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException e) {
				e.printStackTrace();
			}

		});
	}

	Object getBean(String id) {
		return this.instances.get(id);
	}

}
