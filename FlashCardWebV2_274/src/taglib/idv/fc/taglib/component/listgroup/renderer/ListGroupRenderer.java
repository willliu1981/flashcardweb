package idv.fc.taglib.component.listgroup.renderer;

import idv.fc.model.Flashcard;

public interface ListGroupRenderer<T> {



	String getRenderedResult(Flashcard model);

}
