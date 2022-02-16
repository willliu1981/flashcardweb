package test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import idv.kwl.model.User;

public class UserPorcessorBuilder {
	static class Model<T> extends HashMap<String, T> {
		private String condition;
		private T object;

		public String getCondition() {
			return condition;
		}

		public void setCondition(String condition) {
			this.condition = condition;
		}

		public T getObject(String key) {
			return this.get(key);
		}

		public void addObject(String key, T t) {
			this.put(key, t);
		}

	}

	private final static UserPorcessorBuilder builder = new UserPorcessorBuilder();

	private List<IProcess<List<User>, List<User>>> processors = new ArrayList<>();
	private IProcess<List<User>, List<User>> holdProcessor;

	private UserPorcessorBuilder() {

	}

	public static UserPorcessorBuilder instance() {
		return builder;
	}

	public UserPorcessorBuilder addProcessor(
			IProcess<List<User>, List<User>> processor) {
		if (this.holdProcessor != null) {
			return addNextProcessor(processor);
		}
		this.holdProcessor = processor;
		this.processors.add(this.holdProcessor);

		return this;
	}

	public UserPorcessorBuilder addNextProcessor(
			IProcess<List<User>, List<User>> processor) {
		if (this.holdProcessor != null) {
			this.holdProcessor.setInnerProcess(processor);
		}
		this.holdProcessor = null;
		addProcessor(processor);

		return this;
	}

	public List<IProcess<List<User>, List<User>>> getProcessors() {
		return this.processors;
	}

}
