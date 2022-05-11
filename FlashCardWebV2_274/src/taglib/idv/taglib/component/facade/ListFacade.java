package idv.taglib.component.facade;

import idv.fc.taglib.impl.list.FlashcardHolderListFacade;
import idv.fc.taglib.impl.list.FlashcardListFacade;
import idv.taglib.component.ContextPath;

public abstract class ListFacade {
	public static final Class<FlashcardListFacade> FLASHCARD = FlashcardListFacade.class;
	public static final Class<FlashcardHolderListFacade> FLASHCARDHOLDER = FlashcardHolderListFacade.class;

	public abstract boolean hasNextListItem();

	public abstract String getListHeader();

	public abstract String getListItem();

	public abstract String getModalHeader();

	public abstract String getModalBody();

	public abstract String getModalFooter();

	public abstract void setContextPath(String contextPath);

	public abstract ContextPath getContextPath();

	public abstract String getJumbotronTitle();

	public abstract String getActive();

	public abstract String getPathForCRUD();

	public abstract String getPathForPager();

}
