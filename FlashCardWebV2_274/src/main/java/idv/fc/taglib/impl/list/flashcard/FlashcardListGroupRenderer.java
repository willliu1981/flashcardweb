package idv.fc.taglib.impl.list.flashcard;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import idv.fc.model.Flashcard;
import idv.taglib.component.common.impl.Badge;
import idv.taglib.component.itf.TaglibComponentItem;
import idv.taglib.component.listgroup.ListGroupItemHeading;
import idv.taglib.component.listgroup.ListGroupItemText;
import idv.taglib.component.listgroup.renderer.ListGroupRenderere;
import idv.taglib.control.Handler;
import idv.taglib.factory.ComponentFactory;
import idv.taglib.factory.ListFacade;
import idv.taglib.tool.Scripts;
import idv.taglib.tool.Taglibs;

public class FlashcardListGroupRenderer extends ListGroupRenderere<Flashcard> {
	private ListFacade facade;
	private final String badgeSpanSheet = "text-align: center; padding-left: 20px;"
			+ " padding-right: 20px;";
	private String title;

	public FlashcardListGroupRenderer(ListFacade facade, String title) {
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

		TaglibComponentItem cmptTitle = ComponentFactory
				.getDefaultComponent("h3").addStyleSheet("color:green")
				.setBody(title);

		return Taglibs.getStringBuilder().append(badge.getHtmlCode())
				.append(cmptTitle.getHtmlCode()).toString();
	}

	@Override
	public String getRenderedEachBody(Flashcard model) {
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
						model.getTerm(), model.getDefinition()));
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
		heading.setBody(model.getTerm());

		//text
		ListGroupItemText text = new ListGroupItemText();
		//gap
		String gap = "<span style='width:10px; display: inline-block;'></span>";

		text.addStyleSheet("font-size:22px");
		text.setBody(gap + "(id:" + model.getId() + ")" + gap
				+ model.getDefinition());

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
