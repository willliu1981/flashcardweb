package idv.taglib.component.modal;

import idv.taglib.component.adapter.TablibComponentAdapter;
import idv.taglib.component.itf.TaglibRenderer;
import idv.taglib.controlmodel.Result;

public class Modal<T> extends TablibComponentAdapter<T> {

	@Override
	public void setRenderer(TaglibRenderer<T> renderer) {
		this.renderer = renderer;
	}

}
