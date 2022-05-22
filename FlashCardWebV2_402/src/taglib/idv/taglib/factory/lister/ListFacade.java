package idv.taglib.factory.lister;

import idv.fc.taglib.impl.list.flashcard.FlashcardListFacade;
import idv.fc.taglib.impl.list.flashcardholder.FlashcardHolderListFacade;
import idv.fc.taglib.impl.list.holderdata.HolderDataDTOListFacade;
import idv.taglib.controlmodel.ContextPath;
import idv.taglib.controlmodel.Result;

public abstract class ListFacade {
	public static final Class<FlashcardListFacade> FLASHCARD = FlashcardListFacade.class;
	public static final Class<FlashcardHolderListFacade> FLASHCARDHOLDER = FlashcardHolderListFacade.class;
	public static final Class<HolderDataDTOListFacade> HOLDERDATA = HolderDataDTOListFacade.class;

	public abstract boolean hasNextListItem();

	public abstract Result getListHeader();

	public abstract String getListItem();

	public abstract Result getModalHeader();

	public abstract Result getModalBody();

	public abstract Result getModalFooter();

	public abstract void setContextPath(String contextPath);

	public abstract ContextPath getContextPath();

	public abstract String getJumbotronTitle();

	public abstract String getActive();

	public abstract String getPathForCRUD();

	public abstract String getPathForPager();

}
