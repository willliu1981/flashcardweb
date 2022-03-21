package test6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idv.tool.Debug;

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
				Method method = null;
				try {
					switch (type) {
					case BeanProperty.BASE:
						method = action.getClass().getMethod(p.getName(), String.class);
						method.invoke(action, p.getValue());
						break;
					case BeanProperty.CLASS:
						Object value = instances.get(p.getValue());
						method = action.getClass().getMethod(p.getName(),
								value.getClass());
						method.invoke(action, value);
						break;

					default:
						break;
					}

				} catch (NoSuchMethodException | SecurityException
						| IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					e.printStackTrace();
				}

			});

		});
	}

	private void createInstance() {
		this.builderInfos.forEach(info -> {
			try {
				Class<?> clazz = Class.forName(info.getClassString());
				Object instance = clazz.newInstance();
				instances.put(info.getId(), instance);
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
