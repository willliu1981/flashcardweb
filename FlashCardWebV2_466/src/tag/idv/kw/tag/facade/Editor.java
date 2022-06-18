package idv.kw.tag.facade;

import idv.excpetion.ExceptionFactory;
import idv.kw.tag.itf.TagFacade;
import idv.kw.tag.model.Attribute;
import idv.kw.tag.model.Result;

/**
 * 由FormTag 引用
 * @author Kuanwei
 *
 * @param <T>
 */
public abstract class Editor<T> implements TagFacade {
	private T data;
	private Attribute attributes = new Attribute();

	private Editor() {
	}

	protected Editor(T data) {
		this.data = data;
		this.init();
	}

	protected void addAttribute(String k, String v) {
		this.attributes.put(k, v);
	}

	public T getData() {
		return data;
	}

	public Attribute getAttributes() {
		return attributes;
	}



}
