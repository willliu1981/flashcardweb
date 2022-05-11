package idv.fc.taglib.impl.list.flashcardholder;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import idv.fc.model.Flashcard;
import idv.fc.model.FlashcardHolder;
import idv.taglib.component.common.impl.Badge;
import idv.taglib.component.facade.ListFacade;
import idv.taglib.component.listgroup.ListGroupItemHeading;
import idv.taglib.component.listgroup.ListGroupItemText;
import idv.taglib.component.listgroup.renderer.ListGroupRenderere;
import tool.taglib.Scripts;
import tool.taglib.Taglibs;

public class FlashcardHolderListGroupRenderer
		extends ListGroupRenderere<FlashcardHolder> {
	private ListFacade facade;
	private final String badgeSpanSheet = "text-align: center; padding-left: 20px;"
			+ " padding-right: 20px;";
	private String title;

	public FlashcardHolderListGroupRenderer(ListFacade facade, String title) {
		this.facade = facade;
		this.title = title;
	}

	@Override
	public String getRenderedHeader() {
		StringBuilder sbScript = new StringBuilder();
		sbScript.append("location.href='")
				.append(this.facade.getContextPath().getPath()).append("/")
				.append(this.facade.getPathForCRUD()).append("'");

		Badge badge = new Badge();
		badge.addStyleSheet(badgeSpanSheet);
		badge.addStyleSheet("font-size:24px");
		badge.setBody("ADD");
		badge.onClick(sbScript.toString());

		StringBuilder sbTitleMsg = Taglibs.getStringBuilder().append("<h3>")
				.append(title).append("</h3>");

		return Taglibs.getStringBuilder().append(badge.getHtmlCode())
				.append(sbTitleMsg).toString();
	}

	@Override
	public String getRenderedEachBody(FlashcardHolder model) {
		//delete badge begin
		Badge deleteBadge = new Badge();
		deleteBadge.addStyleSheet(badgeSpanSheet);
		deleteBadge.addStyleSheet("background:red");
		deleteBadge.addStyleSheet("font-size:18px");
		deleteBadge.addAttribute("data-target", "#listDeleteModal")
				.addAttribute("data-toggle", "modal");
		deleteBadge.setBody("DELETE");
		deleteBadge.onClick(Scripts.getScript("modelValues",
				model.getId().toString(), model.getName(),
				model.getFcId() == null ? "N/A" : model.getFcId().toString()));
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
		heading.setBody(model.getName());

		//text
		ListGroupItemText text = new ListGroupItemText();
		//gap
		String gap = "<span style='width:10px; display: inline-block;'></span>";
		text.addStyleSheet("font-size:26px");
		text.setBody(gap + "(id:" + model.getId() + ")" + gap + "fc-id: "
				+ (model.getFcId() == null ? "N/A"
						: model.getFcId().toString()));

		return Stream
				.of(deleteBadge.getHtmlCode(), editBadge.getHtmlCode(),
						heading.getHtmlCode(), text.getHtmlCode())
				.collect(Collectors.joining());
	}

	@Override
	public String getRenderedFooter() {
		return EMPTY;
	}

}