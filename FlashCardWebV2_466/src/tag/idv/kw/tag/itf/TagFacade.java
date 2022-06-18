package idv.kw.tag.itf;

import idv.kw.tag.model.Attribute;
import idv.kw.tag.model.Result;

public interface TagFacade {
	String EMPTY = "";

	public Attribute getAttributes();

	void init();
}
