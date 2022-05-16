package idv.kw.tag.itf;

import idv.kw.tag.model.Attribute;
import idv.kw.tag.model.Result;

public interface TagFacade {
	public Attribute getAttributes();

	public Result getHeader();

	public Result getBody();

	public Result getFooter();

	void init();
}
