package idv.fc.taglib.component.listgroup.renderer.impl;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import idv.fc.model.Flashcard;
import idv.fc.taglib.component.common.Badge;
import idv.fc.taglib.component.common.Script;
import idv.fc.taglib.component.listgroup.ListGroupItemHeading;
import idv.fc.taglib.component.listgroup.ListGroupItemText;
import idv.fc.taglib.component.listgroup.renderer.ListGroupRenderere;
import tool.taglib.Scripts;

public class FlashcardListGroupRenderer extends ListGroupRenderere<Flashcard> {
	private final String pathForCRUD = "flashcard";
	private final String badgeSpanSheet = "text-align: center; padding-left: 20px;"
			+ " padding-right: 20px;";
	private HttpServletRequest request;

	public FlashcardListGroupRenderer(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public String getRenderedTitle() {
		StringBuilder scriptSB = new StringBuilder();
		scriptSB.append("location.href='").append(request.getContextPath())
				.append("/").append(pathForCRUD).append("'");

		Badge badge = new Badge();
		badge.addStyleSheet(badgeSpanSheet);
		badge.addStyleSheet("font-size:24px");
		badge.setText("ADD");
		badge.onClick(scriptSB.toString());

		return badge.getHtmlCode();
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
		deleteBadge.setText("DELETE");
		deleteBadge.onClick(
				Scripts.getScript("modelValues", model.getId().toString(),
						model.getTerm(), model.getDefinition()));
		//delete badge end

		//edit badge begin
		Badge editBadge = new Badge();
		editBadge.addStyleSheet(badgeSpanSheet);
		//editBadge.addStyleSheet("background:blue");//註解以使用預設藍色
		editBadge.addStyleSheet("font-size:17px");
		editBadge.setText("EDIT");
		editBadge.onClick(Scripts.getScriptWithHref(request, pathForCRUD,
				model.getId().toString()));
		//edit badge end

		//heading
		ListGroupItemHeading heading = new ListGroupItemHeading();
		heading.addHtmlClass("h3");
		heading.setText(model.getTerm());

		//text
		ListGroupItemText text = new ListGroupItemText();
		text.addStyleSheet("font-size:22px");
		text.setText(model.getDefinition());

		//gap
		String gap = "<span style='width:10px; display: inline-block;'></span>";

		return Stream
				.of(deleteBadge.getHtmlCode(), editBadge.getHtmlCode(),
						heading.getHtmlCode(), gap, text.getHtmlCode())
				.collect(Collectors.joining());
	}

	@Override
	public String getRenderedFooter() {
		return EMPTY;
	}

}
