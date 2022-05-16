package idv.fc.taglib.impl.list.holderdata;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import idv.fc.model.HolderData;
import idv.taglib.component.common.impl.Form;
import idv.taglib.component.common.impl.ModalBodyItem;
import idv.taglib.component.modal.ModalTitle;
import idv.taglib.component.modal.renderer.ModalRenderer;
import idv.taglib.controlmodel.Handler;
import idv.taglib.factory.lister.ListFacade;
import idv.taglib.tool.Taglibs;

public class HolderDataDeleteModalRenderer extends ModalRenderer<HolderData> {
	private ListFacade facade;
	private String title;

	public HolderDataDeleteModalRenderer(ListFacade facade, String title) {
		this.facade = facade;
		this.title = title;
	}

	/*
	 * only Title info
	 */
	@Override
	public String getRenderedHeader(Handler handler) {
		ModalTitle title = new ModalTitle();
		title.setBody(this.title);

		return title.getHtmlCode();
	}

	@Override
	public String getRenderedBody(Handler handler) {
		ModalBodyItem label1 = new ModalBodyItem();
		label1.addStyleSheet("font-size:24px;");

		ModalBodyItem label2 = new ModalBodyItem();
		label2.addStyleSheet("font-size:20px;");

		return Stream.of(label1.getHtmlCode(), label2.getHtmlCode())
				.map(x -> "<p>" + x + "</p>").collect(Collectors.joining());
	}

	@Override
	public String getRenderedFooter(Handler handler) {
		StringBuilder sbAction = Taglibs.getStringBuilder()
				.append(this.facade.getContextPath().getPath()).append("/")
				.append(this.facade.getPathForCRUD()).append("/");

		Form form = new Form();
		form.setId("modal_form");
		form.setAction(sbAction.toString());
		form.setMethod("post");
		form.setBody(Handler.BODY);
		handler.setAttribute("btnCloseName", "開閉");
		handler.setAttribute("btnDeleteName", "刪除");

		return form.getHtmlCode();
	}

}
