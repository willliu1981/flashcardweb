package idv.fc.taglib.impl.list.holderdata;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import idv.fc.model.HolderData;
import idv.fc.model.dto.HolderDataDTO;
import idv.taglib.component.common.impl.Badge;
import idv.taglib.component.listgroup.ListGroupItemHeading;
import idv.taglib.component.listgroup.ListGroupItemText;
import idv.taglib.component.listgroup.renderer.ListGroupRenderere;
import idv.taglib.controlmodel.Handler;
import idv.taglib.factory.lister.ListFacade;
import idv.taglib.tool.Scripts;
import idv.taglib.tool.Taglibs;

public class HolderDataDTOListGroupRenderer
		extends ListGroupRenderere<HolderDataDTO> {
	private ListFacade facade;
	private final String badgeSpanSheet = "text-align: center; padding-left: 20px;"
			+ " padding-right: 20px;";
	private String title;

	public HolderDataDTOListGroupRenderer(ListFacade facade, String title) {
		this.facade = facade;
		this.title = title;
	}

	@Override
	public String getRenderedHeader(Handler handler) {
		StringBuilder sbScript = new StringBuilder();
		sbScript.append("location.href='")
				.append(this.facade.getContextPath().getPath()).append("/")
				.append(this.facade.getPathForCRUD()).append("'");

		Badge badge = new Badge();
		badge.addStyleSheet(badgeSpanSheet);
		badge.addStyleSheet("font-size:24px");
		badge.setBody("ADD");
		badge.onClick(sbScript.toString());

		StringBuilder sbTitleMsg = Taglibs.getStringBuilder()
				.append("<h3 style='color:orange;'>").append(title)
				.append("</h3>");

		return Taglibs.getStringBuilder().append(badge.getHtmlCode())
				.append(sbTitleMsg).toString();
	}

	@Override
	public String getRenderedEachBody(HolderDataDTO model) {
		//delete badge begin
		Badge deleteBadge = new Badge();
		deleteBadge.addStyleSheet(badgeSpanSheet);
		deleteBadge.addStyleSheet("background:red");
		deleteBadge.addStyleSheet("font-size:18px");
		deleteBadge.addAttribute("data-target", "#listDeleteModal")
				.addAttribute("data-toggle", "modal");
		deleteBadge.setBody("DELETE");
		deleteBadge.onClick(
				Scripts.getScript("modelValues", model.getId().toString(),
						model.getId().toString(), model.getFhId().toString()));
		//delete badge end

		//edit badge begin
		Badge editBadge = new Badge();
		editBadge.addStyleSheet(badgeSpanSheet);
		//editBadge.addStyleSheet("background:blue");//註解以使用預設藍色
		editBadge.addStyleSheet("font-size:17px");
		editBadge.setBody("EDIT");
		editBadge.onClick(Scripts.getScriptWithHref(
				this.facade.getContextPath().getPath(),
				this.facade.getPathForCRUD(), model.getId().toString()));
		//edit badge end

		//heading
		ListGroupItemHeading heading = new ListGroupItemHeading();
		heading.addHtmlClass("h3");
		heading.setBody(model.getId().toString());

		//text
		ListGroupItemText text = new ListGroupItemText();
		//gap
		String gap = "<span style='width:10px; display: inline-block;'></span>";
		text.addStyleSheet("font-size:22px");
		text.setBody(gap + gap + model.getFlashcardHolder().getName() + gap
				+ "(" + model.getFhId().toString() + ")");

		return Stream
				.of(deleteBadge.getHtmlCode(), editBadge.getHtmlCode(),
						heading.getHtmlCode(), text.getHtmlCode())
				.collect(Collectors.joining());
	}

	@Override
	public String getRenderedFooter(Handler handler) {
		return Handler.EMPTY;
	}

}
