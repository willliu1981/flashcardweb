package idv.kw.tag.facade;

import idv.kw.tag.itf.TagFacade;
import idv.kw.tag.model.Attribute;
import idv.kw.tag.model.Result;

/**
 * 由FormTag 引用
 * @author Kuanwei
 *
 * @param <T>
 */
public class Editor<T> implements TagFacade {
	private T data;
	private Attribute attribute;

	public Editor(T data) {
		this.data = data;
	}

	@Override
	public Result getHeader() {
		return null;
	}

	@Override
	public Result getBody() {
		return null;
	}

	@Override
	public Result getFooter() {
		return null;
	}

	@Override
	public Attribute getAttribute() {
		return this.attribute;
	}

}
